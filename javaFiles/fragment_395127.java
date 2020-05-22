HttpGet httpGet = new HttpGet(url);
HttpParams httpParameters = new BasicHttpParams();
// Set the timeout in milliseconds until a connection is established.
// The default value is zero, that means the timeout is not used. 
int timeoutConnection = 3000;
HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
// Set the default socket timeout (SO_TIMEOUT) 
// in milliseconds which is the timeout for waiting for data.
int timeoutSocket = 5000;
HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
HttpResponse response = httpClient.execute(httpGet);