public DynamoDBMapper(
        final AmazonDynamoDB dynamoDB,
        final DynamoDBMapperConfig config,
        final AttributeTransformer transformer,
        final AWSCredentialsProvider s3CredentialsProvider) {
    super(config);
    ...
    this.db = dynamoDB;
    ...
}