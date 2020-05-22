AwsSyncClientBuilder builder =  AmazonS3ClientBuilder.standard();

ClientConfiguration cc = new ClientConfiguration();
cc.setProxyHost("<proxyAddress>");
cc.setProxyPort(<proxyPort>);

AWSCredentialsProvider credentials = new DefaultAWSCredentialsProviderChain();

AmazonS3Client s3 = (AwsSyncClientBuilder) builder
        .withClientConfiguration(cc)
        .withCredentials(credentials)
        .withRegion(Regions.US_EAST_1);