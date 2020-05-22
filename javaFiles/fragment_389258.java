@Configuration
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {

      public Neo4jConfig() {
          setBasePackage("model");// My Entity package
      }     
   @Bean
   public SpringRestGraphDatabase graphDatabaseService() {      
        return new SpringRestGraphDatabase("http://localhost:7474/db/data");
  }   
  @Override
  @Bean(name = "transactionManager")
  public PlatformTransactionManager neo4jTransactionManager() throws Exception {
     return new JtaTransactionManagerFactoryBean(getGraphDatabaseService()).getObject();
  }    
}