Map<String, AttributeValue> expressionAttributeValues = new HashMap<String, AttributeValue>();
expressionAttributeValues.put(":val1", new AttributeValue().withS("someValue1"));
expressionAttributeValues.put(":val2", new AttributeValue().withS("someValue2"));

DynamoDBQueryExpression<Item> queryExpression = new DynamoDBQueryExpression<Item>()
    .withHashKeyValues(itemKey)
    .withFilterExpression("COLUMN_1 <> :val1 AND COLUMN_1 <> :val2")
    .withExpressionAttributeValues(expressionAttributeValues)
    .withLimit(pPageSize);