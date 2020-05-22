@Resource
private Mongo mongo;

@Bean
MongoFactoryBean mongo() {
     return new MongoFactoryBean();
}