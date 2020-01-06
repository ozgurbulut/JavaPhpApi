package com.example.myapplication33;
import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    private void jsonParse() {

        String url = "https://www.aksasdiving.com/test.php";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Button buttonClean = findViewById(R.id.button_clean);

                            JSONArray jsonArray = response.getJSONArray("data");
                            ArrayList<String> items = new ArrayList<String>();
                            final ListView listView =  findViewById(R.id.listView1);
                            buttonClean.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    listView.setAdapter(null);
                                }
                            });
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                int firstName = employee.getInt("id");
                                final String command = employee.getString("command");
                                String time = employee.getString("time");

                                items.add(command+"--"+time);
                               ArrayAdapter<String> itemsAdapter =new ArrayAdapter<String>(MainActivity.this, layout.simple_list_item_1, items);
                                listView.setAdapter(itemsAdapter);
                                // mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                            System.out.println("Burada"+items);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
