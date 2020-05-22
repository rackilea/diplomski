List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("param1","foobar"));
URI uri = URIUtils.createURI("http", "myhost.com", -1, "mypath",
URLEncodedUtils.format(params, "UTF-8"), null);

HttpGet httpGet = new HttpGet(uri);
HttpClient httpClient = new DefaultHttpClient();
// set the connection timeout value to 30 seconds (30000 milliseconds)
final HttpParams httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(httpParams, 30000);
httpClient = new DefaultHttpClient(httpParams);
HttpResponse httpResponse = httpClient.execute(httpGet);
String result = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");