DefaultHttpClient client = new DefaultHttpClient();
    ClientConnectionManager mgr = client.getConnectionManager();
    HttpParams params = client.getParams();
    int maxConnections = 100;
    params.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, new ConnPerRouteBean(maxConnections));
    params.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, maxConnections);
    ThreadSafeClientConnManager conman = new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry());
    client = new DefaultHttpClient(conman, params);