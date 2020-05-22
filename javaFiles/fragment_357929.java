public HttpResponse sendStuff (args) {
    HttpPost post = null;
    try {
        HttpClient client = HttpClientBuilder.create().build();

        post = new HttpPost(servletUrl);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(<nameString>, <valueString>));

        post.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(post);
        response.getStatusLine().getStatusCode();
        return response;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}