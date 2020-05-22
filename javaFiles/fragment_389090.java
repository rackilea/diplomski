@Override
public void afterPropertiesSet() throws Exception {
    Assert.state(template != null, "An implementation of MongoOperations is required.");
    Assert.state(type != null, "A type to convert the input into is required.");
    Assert.state(query != null, "A query is required.");
    Assert.state(sort != null, "A sort is required.");
}