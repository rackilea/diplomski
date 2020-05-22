DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost("http://search.twitter.com/search.atom?q=elkstein&count=5");
HttpResponse response = httpClient.execute(postRequest);

HttpEntity entity = response.getEntity();
String body = IOUtils.toString(entity.getContent(), "UTF-8");