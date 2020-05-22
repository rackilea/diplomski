private RestClient buildRestClient(ElasticRequestVO elasticRequestVO) {
    String elasticHost =
            StringUtils.isNotEmpty(elasticRequestVO.getElasticHost()) ? elasticRequestVO.getElasticHost()
                    : elasticSearchHost;
    int elasticPort =
            (elasticRequestVO.getElasticPort() != 0) ? elasticRequestVO.getElasticPort() : elasticSearchPort;
    String elasticUser =
            StringUtils.isNotEmpty(elasticRequestVO.getElasticUser()) ? elasticRequestVO.getElasticUser()
                    : elasticSearchUser;
    String elasticPassword =
            StringUtils.isNotEmpty(elasticRequestVO.getElasticPassword()) ? elasticRequestVO.getElasticPassword()
                    : elasticSearchPassword;
    HttpHost host = new HttpHost(elasticHost, elasticPort);
    RestClientBuilder restClientBuilder = RestClient.builder(host);

    Optional<String> encodedAuth = getAuthenticationHeader(elasticUser, elasticPassword);

    if (encodedAuth.isPresent()) {
        Header[] requestHeaders =
                new Header[] {new BasicHeader(org.apache.http.HttpHeaders.AUTHORIZATION, encodedAuth.get())};
        restClientBuilder.setDefaultHeaders(requestHeaders);
    }
    return restClientBuilder.build();
}