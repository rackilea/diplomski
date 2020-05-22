AWSCredentialsProvider aWSCredentialsProvider =
  new SystemPropertiesCredentialsProvider();
    //the above line may be substituted for any valid
    //*Provider implementation
AWSCredentials aWSCredentials =
  aWSCredentialsProvider.getCredentials();
AmazonDynamoDBClient amazonDynamoDBClient =
  new AmazonDynamoDBClient(aWSCredentials);
...
amazonDynamoDBClient.listTables();
  //the above line is where the ExpiredTokenException is eventually thrown