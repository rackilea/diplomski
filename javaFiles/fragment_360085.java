...
URL newEndpoint = new URL("NEW_ENDPOINT_URL");
QName qname = new QName("http://ws.mycompany.tld","EchoService"); 

EchoService service = new EchoService(newEndpoint, qname);
Echo port = service.getEchoPort();

System.out.println("Server said: " + echo.echo(args[0]));
...