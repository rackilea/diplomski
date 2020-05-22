@Configuration
@ImportResource("applicationContext.xml")
class SpringConfiguration extends Neo4jConfiguration {
    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder("db")
            .setConfig("enable_remote_shell", "true").newGraphDatabase();
    }
}