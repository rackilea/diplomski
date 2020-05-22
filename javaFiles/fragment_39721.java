public static void main(String[] args) {

    BasicCookieStore cookieStore = null;
    HttpResponse httpResponse = null;
    HttpClient httpClient = HttpClients.createDefault();
    while (true) {
        HttpUriRequest request = new HttpGet("http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html");
        try {
            httpResponse = httpClient.execute(request);
            httpResponse.getEntity().getContent().close();
            System.out.println(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            System.out.println(httpResponse.getStatusLine().getStatusCode());
            e.printStackTrace();
        }
    }
}