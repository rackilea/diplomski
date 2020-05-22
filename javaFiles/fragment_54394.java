BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(AccessKey,SecretAccessKey);
AmazonSNS snsClient = AmazonSNSClient
                      .builder()
                      .withRegion(your_region)
                      .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                      .build();