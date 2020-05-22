public void sendGet(String url, CookieStore cookieStore) throws Exception {
    ...
    HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

    HttpGet request = new HttpGet(uri);  // or HttpPost...
    request.addHeader("User-Agent", USER_AGENT);
    HttpResponse response = client.execute(request);

    BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    ...
}