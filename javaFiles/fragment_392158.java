public static class BrokenPoolingHttpClientConnectionManager
          extends PoolingHttpClientConnectionManager 
{

    public BrokenPoolingHttpClientConnectionManager(
            Registry<ConnectionSocketFactory> socketFactoryRegistry) {

        super(socketFactoryRegistry);
    }

    @Override
    public void connect(
                    HttpClientConnection managedConn, 
                    HttpRoute route, 
                    int connectTimeout, 
                    HttpContext context) throws IOException  {

        throw new RuntimeException("As expected");
    }
}

static PoolingHttpClientConnectionManager cm;
static CloseableHttpClient httpClient;

static {

        HttpClientContext clientContext = HttpClientContext.create();

        final Registry<ConnectionSocketFactory>
            registry =
            RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .build();

        cm = new BrokenPoolingHttpClientConnectionManager(registry);

        httpClient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();

}


public static void main(String a[]) throws ClientProtocolException, IOException, JSONException {

        HttpGet httpRequest = new HttpGet("http://www.google.com/");
        httpRequest.setHeader("Connection", "keep-alive");
        CloseableHttpResponse response2;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");

        int i;
        for (i = 0; i < 10; i++) {
          response2 = httpClient.execute(httpRequest);

          System.out.println(String.format("response status=%s", response2.getStatusLine()));

          String result = EntityUtils.toString(response2.getEntity());
          System.out.println(String.format("response size=%d", result.length()));

          Date date = new Date();
          System.out.println(dateFormat.format(date));
          response2.close();
        }
}