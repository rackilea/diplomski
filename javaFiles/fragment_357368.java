@Bean
RestHighLevelClient elasticsearchClient() {
    return new RestHighLevelClient(RestClient.builder(
            new HttpHost(host, port)
    ));
}

@Primary
@Bean
public ElasticsearchRestTemplate elasticsearchTemplate() {
    CustomElasticSearchConverter converter = new CustomElasticSearchConverter(new SimpleElasticsearchMappingContext(), createConversionService());
    return new ElasticsearchRestTemplate(elasticsearchClient(), converter);
}

private DefaultConversionService createConversionService() {
    return new DefaultConversionService();
}