@Bean
public MongoTemplate mongoTemplate() throws Exception {

    MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getDatabaseName());
    MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
    mongoMapping.setCustomConversions(customConversions()); 
    mongoMapping.afterPropertiesSet();
    return mongoTemplate;

}

public CustomConversions customConversions() {
    return new CustomConversions(Arrays.asList(new Decimal128ToBigDecimalConverter(), new BigDecimalToDecimal128Converter()));
}


/* (non-Javadoc)
 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
 */
@Bean
@Override
public Mongo mongo() throws Exception
{
    return new MongoClient();
}