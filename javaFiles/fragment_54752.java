@Configuration
@EnableElasticsearchRepositories( 
    basePackages = {"com.company.data.repositories.shared"},
    elasticsearchTemplateRef = "sharedElasticsearchTemplate")
public class SharedElasticsearchConfiguration {

    @Bean(name="sharedElasticsearchTemplate")
    public ElasticsearchTemplate sharedTemplate() {
       //code to create connection to shared ES cluster
    }
}