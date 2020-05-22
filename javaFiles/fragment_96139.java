@Bean
public MongoDbFactory mongoDbFactory() throws Exception {
    MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
    optionsBuilder.connectTimeout(300);
    optionsBuilder.socketTimeout(300);
    optionsBuilder.serverSelectionTimeout(300);
    return new SimpleMongoDbFactory(new MongoClientURI(mongoUri, optionsBuilder));
}