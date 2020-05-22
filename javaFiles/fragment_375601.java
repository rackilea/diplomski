private void createRequest(HttpClient httpClient) throws UnsupportedEncodingException, IOException {
    HttpPost post = new HttpPost("http://myreviewboardserver/api/review-requests/");
    List<NameValuePair> data = new ArrayList<NameValuePair>();
    data.add(new BasicNameValuePair("repository", "https://mysvnrepositorypath"));
    post.setEntity(new UrlEncodedFormEntity(data));
    HttpResponse response = httpClient.execute(post);
    HttpEntity entity = response.getEntity();

    entity.writeTo(System.out);
    EntityUtils.consume(entity);
}