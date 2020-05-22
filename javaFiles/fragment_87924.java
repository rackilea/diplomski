CommonsHttpOAuthConsumer consumer = null;
    consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
    consumer.setTokenWithSecret(oaut_token, tokenSecret);

   // Use the apache method instead - probably should make this part persistent until
   // you are done issuing API calls    
   HttpParams parameters = new BasicHttpParams();
   HttpProtocolParams.setVersion(parameters, HttpVersion.HTTP_1_1);
   HttpProtocolParams.setContentCharset(parameters, HTTP.DEFAULT_CONTENT_CHARSET);
   HttpProtocolParams.setUseExpectContinue(parameters, false);
   HttpConnectionParams.setTcpNoDelay(parameters, true);
   HttpConnectionParams.setSocketBufferSize(parameters, 8192);

   HttpClient httpClient = new DefaultHttpClient();

   SchemeRegistry schReg = new SchemeRegistry();
   schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
   ClientConnectionManager tsccm = new ThreadSafeClientConnManager(parameters, schReg);

   httpClient = new DefaultHttpClient(tsccm, parameters);

   HttpGet get = new HttpGet(targetURL); 

    // sign the request
    consumer.sign(get);

    // send the request & get the response (probably a json object, but whatever)
    String response = httpClient.execute(get, new BasicResponseHandler());

    // shutdown the connection manager - last bit of the apache code 
    httpClient.getConnectionManager().shutdown();

    //Do whatever you want with the returned info 
    JSONObject jsonObject = new JSONObject(response);