DefaultHttpClient httpClient = new DefaultHttpClient();

HttpContext context = new BasicHttpContext();
HttpGet httpGet = new HttpGet("http://www.google.com/");
try {
    HttpResponse httpResponse = httpClient.execute(httpGet, context);
    System.out.println("Response status: " + httpResponse.getStatusLine());
    HttpRequest req = (HttpRequest) context.getAttribute(
            ExecutionContext.HTTP_REQUEST);
    System.out.println("Last request URI: " + req.getRequestLine());
    RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute(
            DefaultRedirectStrategy.REDIRECT_LOCATIONS);
    if (redirectLocations != null) {
        System.out.println("All intermediate redirects: " + redirectLocations.getAll());
    }
    EntityUtils.consume(httpResponse.getEntity());
} finally {
    httpGet.releaseConnection();
}