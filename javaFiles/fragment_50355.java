@Configuration
@EnableSolrRepositories(basePackages={"com.ows.rokomari.repository.solrRepository"}, multicoreSupport=true)
@ComponentScan
public class SolrConfig {

static final String SOLR_HOST = "http://localhost:8983/solr";

@Bean
public SolrClient solrClient() {

return new HttpSolrClient(SOLR_HOST);
}

@Bean
public SolrTemplate solrTemplate(SolrClient solrClient) throws Exception {
return new SolrTemplate(solrClient);
}
}