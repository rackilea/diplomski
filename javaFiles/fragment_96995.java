try {
    SSLContext ssl_ctx = SSLContext.getInstance("TLS");
        TrustManager[ ] trust_mgr = new TrustManager[ ] {
    new X509TrustManager() {
       public X509Certificate[ ] getAcceptedIssuers() { return null; }
       public void checkClientTrusted(X509Certificate[ ] certs, String t) { }
       public void checkServerTrusted(X509Certificate[ ] certs, String t) { }
     }
  };
        ssl_ctx.init(null,                // key manager
                     trust_mgr,           // trust manager
                     new SecureRandom()); // random number generator
        HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
    } catch(NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch(KeyManagementException e) {
        e.printStackTrace();
    }