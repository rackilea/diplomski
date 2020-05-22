SchemeRegistry schemeRegistry = new SchemeRegistry ();

schemeRegistry.register (new Scheme ("http",
    PlainSocketFactory.getSocketFactory (), 80));
schemeRegistry.register (new Scheme ("https",
    new CustomSSLSocketFactory (), 443));

ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager (
    params, schemeRegistry);


return new DefaultHttpClient (cm, params);