List<String> getOtherAttributeList(String tableName) {

    DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient());
    TableDescription tableSchema = dynamoDB.getTable(tableName).describe();

    return tableSchema.getAttributeDefinitions().stream()
            .map(AttributeDefinition::getAttributeName)
            .collect(Collectors.toList());
}