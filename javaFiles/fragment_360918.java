@Configuration
@PropertySource({ "classpath:mongodb-data-source.properties" })
public class MongodbDataSourceConfig extends AbstractMongoConfiguration {

    @Autowired Environment env;

    @Override
    public String getDatabaseName(){
        return env.getRequiredProperty("mongo.name");
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {

        ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(MongoCredential.createScramSha1Credential(
                env.getRequiredProperty("mongo.username"),
                env.getRequiredProperty("mongo.name"),
                env.getRequiredProperty("mongo.password").toCharArray()
        ));
        MongoClientOptions options = new MongoClientOptions.Builder()
            .build();
        return new MongoClient(serverAddress, credentials, options);
    }

}