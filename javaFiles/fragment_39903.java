DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient())

  String getHashKeyAttributeName(String tableName) {

    TableDescription tableSchema = dynamoDB.getTable(tableName).describe();

    return tableSchema.getKeySchema().stream()
            .filter(x -> x.getKeyType().equals(KeyType.HASH.toString()))
            .findFirst().get().getAttributeName();        
  }

  String getSortkeyAttributeName(String tableName) {

    TableDescription tableSchema = dynamoDB.getTable(tableName).describe();

    return tableSchema.getKeySchema().stream()
            .filter(x -> x.getKeyType().equals(KeyType.RANGE.toString()))
            .findFirst().get().getAttributeName();
  }