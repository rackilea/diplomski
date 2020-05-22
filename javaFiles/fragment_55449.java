DefaultHttpClient httpClient = createClient();
HttpParams params = new BasicHttpParams();
HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, new Integer(60000));
params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, new Integer(60000));
params.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true);
httpClient.setParams(params);