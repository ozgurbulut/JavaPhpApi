# Hermes
Your system service has been added to your service. Let’s reload the systemctl daemon to read new file. You need to reload this deamon each time after making any changes in in .service file.


sudo systemctl daemon-reload
Now enable the service to start on system boot, also start the service using the following commands.

sudo systemctl enable dummy.service
sudo systemctl start dummy.service


sudo systemctl status dummy.service


sudo systemctl stop dummy.service          #To stop running service 
sudo systemctl start dummy.service         #To start running service 
sudo systemctl restart dummy.service       #To restart running service 
