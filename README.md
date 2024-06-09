# smiirl analyse
[![stars](https://img.shields.io/github/stars/simon2022/smiirl-analyse?style=social)](https://github.com/simon2022/smiirl-analyse/)

This project describes how the [Smiirl counters](https://www.smiirl.com/ "Smiirl counters") work and how they could possibly be used for other purposes without having to buy the custom counter.



#### API
The counter uses an unencrypted HTTP API:  `http://api.smiirl.com/`


###### config endpoint

```
GET http://api.smiirl.com/v1.0/{mac}/{secret}

{
	"result": true,
	"status": true,
	"v": "smiirl_2.0.7-1",
	"attribute": "number",
	"url": "http://api.smiirl.com/{mac}/number",
	"interval": 300,
	"code": 200
}
```  

###### number endpoint

```
GET http://api.smiirl.com/{mac}/number

{
"number": 12345
}
```



#### Network

The counter registers itself as `espressif` at the router.

Because the data is not encrypted, it is possible to route the traffic to another server.


```
sudo apt-get update
sudo apt-get install dnsmasq

sudo nano /etc/dnsmasq.conf
-> add line: address=/api.smiirl.com/192.168.178.89

sudo systemctl restart dnsmasq
```

Set the DNS server of your router to the IP address of your new dns-server.
Now make sure that you make both API endpoints available on a server (in the example 192.168.178.89) with the values according to your wishes.
