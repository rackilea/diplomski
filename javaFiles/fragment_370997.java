SSLContext sslContext = SSLContexts.custom()
        .useTLS() // Only this turned out to be not enough
        .build();
SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(
        sslContext,
        new String[] {"TLSv1", "TLSv1.1", "TLSv1.2"},
        null,
        SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
CloseableHttpClient client = HttpClients.custom()
        .setSSLSocketFactory(sf)
        .build();