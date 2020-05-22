@Configuration
@EnableTransactionManagement                        // mode = proxy
@EnableNeo4jRepositories(basePackages = "graph.repository")
@ComponentScan({
    "graph.component",
    "graph.service",
    "core.service"
})
public class Neo4jConfig extends Neo4jConfiguration {
    private static final String DB_PATH = "path_to.db";
    private static final String CONFIG_PATH = "path_to.properties";

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder(DB_PATH)
            .loadPropertiesFromFile(CONFIG_PATH).newGraphDatabase();
    }
}