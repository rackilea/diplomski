private MongoConnection mongoConnection;
@Autowired
public void setMongoConnection(MongoConnection mongoConnection) {
    System.out.println("In autowired setter");
    this.mongoConnection = mongoConnection;
}

private Class<T> clazz;
@Autowired
public void setClazz(Class<T> clazz){
    System.out.println("In class Autowired Setter");
    this.clazz = clazz;
}

@Bean
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public Class<T> getClazz(){
    return clazz;
}

public BaseDAOImpl() {
    this.collection = MongoDbUtil.getCollection(mongoConnection.mongoDb(), clazz);
}