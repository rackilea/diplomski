DefaultHttpClient createClient() {
    SchemeRegistry registry = new SchemeRegistry();
    registry.register(new Scheme("https", sf, 6443));

    ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(registry);
    cm.setMaxTotal(maxConnections);
    cm.setDefaultMaxPerRoute(maxConnections);

    HttpHost targetHost = new HttpHost("webserviceIP", webservicePort, "https");
    cm.setMaxForRoute(new HttpRoute(targetHost, null, true), maxConnections);

    return new DefaultHttpClient(cm);
}