class MyVerifier extends AbstractVerifier {

    private final X509HostnameVerifier delegate;

    public MyVerifier(final X509HostnameVerifier delegate) {
        this.delegate = delegate;
    }

    @Override
    public void verify(String host, String[] cns, String[] subjectAlts)
                throws SSLException {
        boolean ok = false;
        try {
            delegate.verify(host, cns, subjectAlts);
        } catch (SSLException e) {
            for (String cn : cns) {
                if (cn.startsWith("*.")) {
                    try {
                          delegate.verify(host, new String[] { 
                                cn.substring(2) }, subjectAlts);
                          ok = true;
                    } catch (Exception e1) { }
                }
            }
            if(!ok) throw e;
        }
    }
}


public DefaultHttpClient getTolerantClient() {
    DefaultHttpClient client = new DefaultHttpClient();
    SSLSocketFactory sslSocketFactory = (SSLSocketFactory) client
            .getConnectionManager().getSchemeRegistry().getScheme("https")
            .getSocketFactory();
    final X509HostnameVerifier delegate = sslSocketFactory.getHostnameVerifier();
    if(!(delegate instanceof MyVerifier)) {
        sslSocketFactory.setHostnameVerifier(new MyVerifier(delegate));
    }
    return client;
}