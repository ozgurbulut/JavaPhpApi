<?php

$servername = "localhost";
$username = "aksasdiv_aksas";
$password = "yelkenli59*";

try {
    $conn = new PDO("mysql:host=$servername;dbname=aksasdiv_tablolar", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  
    //$sql = "SELECT * FROM testapi"; 
    $sorgu = $conn->query("SELECT * FROM testapi"); 
    
    $resultArray = array();
    $tempArray = array();

while($row = $sorgu->fetch(PDO::FETCH_ASSOC)){
     $tempArray = $row;
     array_push($resultArray, $tempArray);
      //  $id = $sonuc['id']; // Veritabanından çektiğimiz id satırını $id olarak tanımlıyoruz.
    //    $baslik = $sonuc['command'];

        //$data = ["id" => $id,"command" => $baslik,];        
//echo json_encode($data);
}
	echo '{"data":'.json_encode($resultArray).'}';

//$result = mysqli_query($conn, $sorgu);
    }
catch(PDOException $e)
    {
    }



?>
