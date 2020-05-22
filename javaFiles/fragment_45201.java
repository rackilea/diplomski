HttpClient httpClient = new DefaultHttpClient();
URI url = new URI("https://s3-eu­west­1.amazonaws.com/developer-application­test/cart/list");
URI url1 = new URI("https://www.google.com/");
HttpGet httpGet = new HttpGet(url);
HttpResponse httpResponse = httpClient.execute(httpGet);
HttpEntity httpEntity = httpResponse.getEntity();