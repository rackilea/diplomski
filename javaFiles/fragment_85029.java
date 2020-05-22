@Configuration
@WebAppConfiguration
@ComponentScan(basePackages = "com.amanu.csa",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class))
@EnableMongoRepositories(repositoryImplementationPostfix = "CustomImpl")
class TestConfig {

    @Bean
    Mongo mongo() throws Exception {
        return new MongoClient("localhost")
    }

    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), "csa_test")
    }

    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate template = new MongoTemplate(mongoDbFactory())
        template.setWriteResultChecking(WriteResultChecking.EXCEPTION)
        return template
    }
}