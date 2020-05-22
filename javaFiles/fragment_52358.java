Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE)
        .register("https", new MyConnectionSocketFactory(SSLContexts.createSystemDefault()))
        .build();
PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(reg);
CloseableHttpClient httpclient = HttpClients.custom()
        .setConnectionManager(cm)
        .build();
try {
    InetSocketAddress socksaddr = new InetSocketAddress("mysockshost", 1234);
    HttpClientContext context = HttpClientContext.create();
    context.setAttribute("socks.address", socksaddr);

    HttpHost target = new HttpHost("localhost", 80, "http");
    HttpGet request = new HttpGet("/");

    System.out.println("Executing request " + request + " to " + target + " via SOCKS proxy " + socksaddr);
    CloseableHttpResponse response = httpclient.execute(target, request, context);
    try {
        System.out.println("----------------------------------------");
        System.out.println(response.getStatusLine());
        EntityUtils.consume(response.getEntity());
    } finally {
        response.close();
    }
} finally {
    httpclient.close();
}