public static void main(String [] args) {

    AmazonDynamoDBClient client = new AmazonDynamoDBClient(new BasicAWSCredentials("akey1", "skey1"));
    client.setEndpoint("http://localhost:8000");
    DynamoDBMapper mapper = new DynamoDBMapper(client);

    client.createTable(new CreateTableRequest()
        .withTableName("nested-data-test")
        .withAttributeDefinitions(new AttributeDefinition().withAttributeName("desc").withAttributeType("S"))
        .withKeySchema(new KeySchemaElement().withKeyType("HASH").withAttributeName("desc"))
        .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L)));

    NestedData u = new NestedData();
    u.setDesc("else");
    Map<String, String> c = new HashMap<String, String>();
    c.put("type", "some");
    u.setConf(c);
    mapper.save(u);

    DynamoDBQueryExpression<NestedData> queryExpression = new DynamoDBQueryExpression<NestedData>();
    queryExpression.withHashKeyValues(u);
    queryExpression.withFilterExpression("conf.#t = :type")
        .addExpressionAttributeNamesEntry("#t", "type") // returns nothing if use "Type"
        .addExpressionAttributeValuesEntry(":type", new AttributeValue("some"));
    for(NestedData u2 : mapper.query(NestedData.class, queryExpression)) {
        System.out.println(u2.getDesc()); // "else"
    }
}