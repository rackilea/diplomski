public class ElasticsearchClient {
//private static final Logger log = LoggerFactory.getLogger(ElasticsearchClient.class);
private final RestHighLevelClient client;

public ElasticsearchClient(ElasticsearchConfig elasticsearchConfig) {
    client = new RestHighLevelClient(RestClient.builder(new HttpHost(elasticsearchConfig.getHost(),
            elasticsearchConfig.getPort(), "http")));
}
}