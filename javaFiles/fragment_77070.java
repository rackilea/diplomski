@Bean
    public IdSClientConfigurationImpl config() throws IOException, IdSClientException {
        ClassPathResource idsclientResource = new ClassPathResource("idsclient.properties");
        IdSClientConfigurationImpl config = new IdSClientConfigurationImpl(idsclientResource.getFile().getPath());
//      IdSClientConfigurationImpl config = new IdSClientConfigurationImpl("src/main/resources/idsclient.properties");
        config.load();
        return config;
    }

    @Bean
    public IdSClient setupIdsClient() throws IOException, IdSClientException {
        IdSClient client = IdSClientFactory.getIdSClient();
        client.setTLSContext(createSSLTrustManager(), createHostnameVerifier());
//      client.setTLSContext(arg0, arg1) // use secure trust manager and hostname verifier in production
        client.init(config);
        return client;
    }

    private X509TrustManager createSSLTrustManager() {
        X509TrustManager tm = new TrustAllX509TrustManager();
        return tm;  
    }

    private HostnameVerifier createHostnameVerifier() {
        HostnameVerifier hv = new SkipAllHostNameVerifier();
        return hv;
    }