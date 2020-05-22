public Boolean deleteItem(String partitionKey, String sortKey) {
    DynamoDBUtil dynamoDBUtil = new DynamoDBUtil();
    AmazonDynamoDB dynamoDBClient = dynamoDBUtil.getDynamoDBClient();
    DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

    Table table = dynamoDB.getTable("demo_table");
    DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
        .withPrimaryKey("partitionKey", partitionKey, "sortKey", sortKey);

    table.deleteItem(deleteItemSpec);
    return true;
}