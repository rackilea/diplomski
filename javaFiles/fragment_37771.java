HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        HttpProtocolParams.setUseExpectContinue(params, false);  
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 10000);
        ConnManagerParams.setMaxTotalConnections(params, 100);
        ConnManagerParams.setTimeout(params, 30000);

        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http",PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https",PlainSocketFactory.getSocketFactory(), 80));
        ThreadSafeClientConnManager manager = new ThreadSafeClientConnManager(params, registry);
        mClient = new DefaultHttpClient(manager, params);