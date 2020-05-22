SchemeRegistry schemeRegistry = new SchemeRegistry();
schemeRegistry.register(
        new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

ClientConnectionManager cm = new ThreadSafeClientConnManager(schemeRegistry);
HttpClient httpClient = new DefaultHttpClient(cm);