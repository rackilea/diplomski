try {
    HttpClient http = new DefaultHttpClient();
    HttpPost   post = new HttpPost("http://www.example.com/process");

    List<NameValuePair> data = new ArrayList<NameValuePair>();
    data.add(new BasicNameValuePair("phone", "value");
    data.add(new BasicNameValuePair("name", "value");
    data.add(new BasicNameValuePair("email", "value");
    data.add(new BasicNameValuePair("comments", "value");
    post.setEntity(new UrlEncodedFormEntity(data));

    HttpResponse response = http.execute(post);
    // do something with the response
}
catch (ClientProtocolException e) {
    // do something
}
catch (IOException e) {
    // do something
}