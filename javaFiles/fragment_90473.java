String TLS_VERSION = "TLSv1.2";
SchemeRegistry registry = new SchemeRegistry();
SSLSocketFactory socketFactory;
try {
    if (Boolean.valueOf(((String) ZConfig.getInstance().getVal("ssl.verify.peer")).toLowerCase())) {
        socketFactory = new SSLSocketFactory(TLS_VERSION, null, null, null, null, null,
                SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    } else {
        socketFactory = new SSLSocketFactory(TLS_VERSION, null, null, null, null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                return true;
            }
        }, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }
    // need both http and https
    registry.register(new Scheme("https", 443, socketFactory));
}