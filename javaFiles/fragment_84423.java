@Primary
@Bean(name = "customerMongoTemplate")
public MongoTemplate customerMongoTemplate() {
  MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), getDatabaseName());
  MappingMongoConverter converter = (MappingMongoConverter) mongoTemplate.getConverter();
  converter.setCustomConversions(customConversions());
  converter.afterPropertiesSet();
  return mongoTemplate;
}