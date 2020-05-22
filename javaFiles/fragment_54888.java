public RestHighLevelClient createESRestClient() {
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(esUserName, esPassword));

    RestClientBuilder restClientBuilder = RestClient
            .builder(new HttpHost(esRestclientHost, 9200, "http"));
    // Use this one if your ElasticSearch server is setup to use username & password authentication
    if (esAuthentication) {
        restClientBuilder.setHttpClientConfigCallback(h -> h.setDefaultCredentialsProvider(credentialsProvider));
    }

    return new RestHighLevelClient(restClientBuilder);
}