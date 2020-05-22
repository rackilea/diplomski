AWSCredentialsProvider aWSCredentialsProvider =
  new SystemPropertiesCredentialsProvider();
    //substitute the above line for any valid *Provider implementation
AmazonDynamoDBClient amazonDynamoDBClient =
  new AmazonDynamoDBClient(aWSCredentialsProvider);
    //the above line is now passing an instance of AWSCredentialsProvider
    //as opposed to AWSCredentials
...
amazonDynamoDBClient.listTables();
  //the above line is now enabled, via the AWSCredentialsProvider, to 
  //automatically refresh the AWSCredentials if/when they have expired