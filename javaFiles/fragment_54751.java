@Configuration
@EnableElasticsearchRepositories( 
    basePackages = {"com.company.data.repositories.private"},
    elasticsearchTemplateRef = "privateElasticsearchTemplate")
public class PrivateElasticsearchConfiguration {

    @Bean(name="privateElasticsearchTemplate")
    public ElasticsearchTemplate privateTemplate() {
       //code to create connection to private ES cluster
    }
}