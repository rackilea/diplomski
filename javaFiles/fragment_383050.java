private DefaultHttpClient httpclient = new DefaultHttpClient();
private HttpGet get = new HttpGet("your url comes here");

protected String[] doInBackground(Void... v) {
    HttpParams httpParameters = new BasicHttpParams();
    // set the timeout in milliseconds until a connection is established
    // the default value is zero, that means the timeout is not used 
    int timeoutConnection = 3000;
    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
    // set the default socket timeout (SO_TIMEOUT) in milliseconds
    // which is the timeout for waiting for data
    int timeoutSocket = 5000;
    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

    httpclient.setParams(httpParameters);

    try {
        HttpEntity entity = httpclient.execute( get ).getEntity();
        FileOutputStream output = new FileOutputStream(outputFile);
        entity.writeTo(output);
        output.close();
        // return something, maybe?
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        httpclient.getConnectionManager().shutdown();
    }
    return null;
}