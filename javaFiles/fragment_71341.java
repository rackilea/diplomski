HttpParams myParams = new BasicHttpParams();

HttpConnectionParams.setSoTimeout(myParams, 10000);
HttpConnectionParams.setConnectionTimeout(myParams, 10000); // Timeout

DefaultHttpClient httpClient = new DefaultHttpClient(myParams);