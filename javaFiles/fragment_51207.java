HttpClient httpClient = new DefaultHttpClient();
HttpGet httpGet = new HttpGet("http://foo.com/bar");
httpGet.addHeader(BasicScheme.authenticate(
 new UsernamePasswordCredentials("user", "password"),
 "UTF-8", false));

HttpResponse httpResponse = httpClient.execute(httpGet);
HttpEntity responseEntity = httpResponse.getEntity();

// read the stream returned by responseEntity.getContent()