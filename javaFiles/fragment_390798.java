@Configuration
@EnableElasticsearchRepositories(repositoryBaseClass = 
ESDemoRepository.class,basePackages="com.example.elasticSearchDemo")
public class ESConfiguration {
@Value("${elasticsearch.host}")
private String EsHost;

@Value("${elasticsearch.port}")
private int EsPort;

@Value("${elasticsearch.clustername}")
private String EsClusterName;


@Bean
public Client client() throws Exception {

    Settings settings = Settings.builder()
            .put("cluster.name", EsClusterName).build();
 return  new PreBuiltTransportClient(settings)
            .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
}

@Bean
public ElasticsearchOperations elasticsearchTemplate() throws Exception {
    return new ElasticsearchTemplate(client());
}