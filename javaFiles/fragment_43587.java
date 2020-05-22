BasicAWSCredentials credentials = new BasicAWSCredentials(awsAcessKeyId, awsSecretKey);

    AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    DescribeRegionsResult describeRegionsResult = ec2Client.describeRegions();
    for(com.amazonaws.services.ec2.model.Region region : describeRegionsResult.getRegions()) {
        System.out.println(region.getRegionName());
    }