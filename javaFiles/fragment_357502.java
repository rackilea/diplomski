HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("fullurl");

List<NameValuePair> pairs = new ArrayList<NameValuePair>();
pairs.add(new BasicNameValuePair("parameter", "variable");
post.setEntity (new UrlEncodedFormEntity(pairs));

HttpResponse response = client.execute(post);