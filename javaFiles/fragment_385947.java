HelloService hello = new HelloService();
HelloPortType helloPort = cliente.getHelloPort();
org.apache.cxf.endpoint.Client client = ClientProxy.getClient(helloPort);
HTTPConduit http = (HTTPConduit) client.getConduit();
http.getClient().setProxyServer("proxy");
http.getClient().setProxyServerPort(8080);
http.getProxyAuthorization().setUserName("user proxy");
http.getProxyAuthorization().setPassword("password proxy");