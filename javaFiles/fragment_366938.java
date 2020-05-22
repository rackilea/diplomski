@Configuration
@EnableNeo4jRepositories(basePackages = "org.springframework.data.neo4j.repository")
static class Config extends Neo4jConfiguration {

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
    }
}