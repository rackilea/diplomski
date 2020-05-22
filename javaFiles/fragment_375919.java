SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
sslContextBuilder.loadTrustMaterial(null, new TrustAllStrategy());
SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
        sslContextBuilder.build());
CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(
        socketFactory).build();