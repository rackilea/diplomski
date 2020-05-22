CloseableHttpClient httpClient = HttpClients.createDefault();

HttpClientContext context = HttpClientContext.create();
HttpGet httpGet = new HttpGet("http://www.google.com/");
CloseableHttpResponse httpResponse = httpClient.execute(httpGet, context);
try {
    System.out.println("Response status: " + httpResponse.getStatusLine());
    System.out.println("Last request URI: " + context.getRequest().getRequestLine());
    URICollection redirectLocations = context.getRedirectLocations();
    if (redirectLocations != null) {
        System.out.println("All intermediate redirects: " + redirectLocations.getAll());
    }
    EntityUtils.consume(httpResponse.getEntity());
} finally {
    httpResponse.close();
}