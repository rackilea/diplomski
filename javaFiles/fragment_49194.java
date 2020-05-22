import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class ElasticsearchConfig {


    // Here all init stuff with @Value(....)


    RestClient lowLevelRestClient;
    RestHighLevelClient client;

    @PostConstruct
    public void init() {
        lowLevelRestClient = RestClient.builder(new HttpHost("host", 9200, "http")).build();
        client = new RestHighLevelClient(lowLevelRestClient);
    }

    @PreDestroy
    public void destroy() throws IOException {
        lowLevelRestClient.close();
    }

    @Bean
    public RestHighLevelClient getClient() {
        return client;
    }

}