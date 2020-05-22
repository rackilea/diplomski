HttpPost httpPost = new HttpPost("http://some-web-site");
List <NameValuePair> nvps = new ArrayList <NameValuePair>();
nvps.add(new BasicNameValuePair("name", "Joe"));
nvps.add(new BasicNameValuePair("email", "joe@smith.com"));
httPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
HttpResponse response = httpClient.execute(httpPost);
HttpEntity result = response.getEntity();