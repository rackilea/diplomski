@Configuration
public class MongoConfig {


    @Bean
    public MongoDbFactory mongoDbFactory() {

        MongoClient mongoClient = new MongoClient("127.0.0.1:27017");

        return new SimpleMongoDbFactory(mongoClient, "IndianFarms" );
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}