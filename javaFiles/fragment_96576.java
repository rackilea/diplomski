public class MongoRepositoryConfig extends AbstractMongoConfiguration { 

    @Value("${db.host.port}")
    private int port;

    @Value("${db.host.name}")
    private String host;

    @Value("${db.name}")
    private String dbname;

    @Override
    public Mongo mongo() throws Exception {
        ServerAddress serverAdress = new ServerAddress(host,port);
        Mongo mongo = new MongoClient(serverAdress);
        mongo.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        return mongo;
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return dbname;
    }
}