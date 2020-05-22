HttpHost proxy = new HttpHost("ip address",port number);
DefaultHttpClient httpclient = new DefaultHttpClient();
httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

HttpPost httpost = new HttpPost(url);
List<NameValuePair> nvps = new ArrayList<NameValuePair>();
nvps.add(new BasicNameValuePair("param name", param));
httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.ISO_8859_1));
HttpResponse response = httpclient.execute(httpost);

HttpEntity entity = response.getEntity();
System.out.println("Request Handled?: " + response.getStatusLine());
InputStream in = entity.getContent();
httpclient.getConnectionManager().shutdown();