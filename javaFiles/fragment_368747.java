@Bean
public RestTemplate restTemplate() {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("my.host.com", 8080));
    requestFactory.setProxy(proxy);

    return new RestTemplate(requestFactory);
}