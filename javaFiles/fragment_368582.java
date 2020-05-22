@Bean
    public HttpProcessor httpRequestCompressionProcessor(String url) throws URISyntaxException {
        return HttpProcessorBuilder.create()
                .add(new GzipHttpRequestInterceptor(url))
                .build();
    }

    @Bean
    public HttpComponentsMessageSender messageGzipSender(String url) throws URISyntaxException {
        return new HttpComponentsMessageSender(HttpClients.custom()
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .setHttpProcessor(httpRequestCompressionProcessor(url))
                .build());
    }