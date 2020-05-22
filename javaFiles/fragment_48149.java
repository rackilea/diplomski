private RestTemplate createRestTemplate() throws Exception {
    final String username = "myusername";
    final String password = "myPass";
    final String proxyUrl = "proxy.nyc.bigtower.com";
    final int port = 8080;

    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials( 
        new AuthScope(proxyUrl, port), 
        new UsernamePasswordCredentials(username, password)
    );

    HttpHost myProxy = new HttpHost(proxyUrl, port);
    HttpClientBuilder clientBuilder = HttpClientBuilder.create();

    clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

    HttpClient httpClient = clientBuilder.build();
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setHttpClient(httpClient);

    return new RestTemplate(factory);
}