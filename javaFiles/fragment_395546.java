HttpClient createClient() {
    HttpParams params = new BasicHttpParams();
    params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
    params.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, HTTP.DEFAULT_CONTENT_CHARSET);
    params.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, true);
    params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30 * 1000);
    params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 30 * 1000);

    SchemeRegistry schReg = new SchemeRegistry();
    schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    ClientConnectionManager conMgr = new ThreadSafeClientConnManager(params, schReg);

    return new DefaultHttpClient(conMgr, params);
}