@Primary
@Bean(name = "customerMongoTemplate")
public MongoTemplate customerMongoTemplate() throws Exception {
  SimpleMongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());

  MongoMappingContext mongoMappingContext = mongoMappingContext();
  mongoMappingContext.setInitialEntitySet(getInitialEntitySet());
  mongoMappingContext.afterPropertiesSet();

  MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), mongoMappingContext);
  converter.setCustomConversions(customConversions());
  converter.afterPropertiesSet();

  return new MongoTemplate(mongoDbFactory, converter);
}