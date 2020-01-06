import urllib.request, json 
import os
with urllib.request.urlopen("http://www.aksasdiving.com/test.php") as url:
	data = json.loads(url.read().decode())
	datas= data['data']
	for x in datas:
		if(x['command']=='Kapat'):
			print("Sistem kapatiliyor")
			os.system("ls")
'''
abc = a.c
call(["vim", abc])
'''
