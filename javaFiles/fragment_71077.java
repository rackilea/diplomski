HttpHost proxy = new HttpHost("someproxy", 8080);
DynamicProxyRoutePlanner routePlanner = new DynamicProxyRoutePlanner(proxy);
CloseableHttpClient httpclient = HttpClients.custom()
    .setRoutePlanner(routePlanner)
    .build();

//Any time change the proxy 
routePlanner.setProxy(new HttpHost("someNewProxy", 9090));