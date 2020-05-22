public List<MyEntity> findByUserIdQuery(String userId) {
    Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
    eav.put(":val1", new AttributeValue().withS(userId));

DynamoDBQueryExpression<MyEntity> queryExpression = new DynamoDBQueryExpression<MyEntity>()
    .withKeyConditionExpression("userId = :val1").withExpressionAttributeValues(eav);

List<MyEntity> list = mapper.query(MyEntity.class, queryExpression);