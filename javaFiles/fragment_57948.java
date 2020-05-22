SSLContext sslContext = SSLContexts.custom().useProtocol("TLSv1").build();
CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLContext(sslContext)
            .addInterceptorFirst(new 
HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
            .build();

HttpComponentsMessageSender sender = new HttpComponentsMessageSender(httpClient);