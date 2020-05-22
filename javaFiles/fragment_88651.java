Client client = ClientProxy.getClient(proxy);
HTTPConduit http = (HTTPConduit) client.getConduit();
HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
httpClientPolicy.setConnectionTimeout(0);
httpClientPolicy.setReceiveTimeout(0);
http.setClient(httpClientPolicy);