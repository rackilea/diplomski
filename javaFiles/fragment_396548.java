AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
ClientConfiguration clientConfig = new ClientConfiguration();
clientConfig.setProtocol(Protocol.HTTP);
AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
conn.setEndpoint("correct end point");
Bucket bucket = conn.createBucket(bucketName);
ObjectListing objects = conn.listObjects(bucket.getName());
do {
    for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
            System.out.println(objectSummary.getKey() + "\t" +
                    objectSummary.getSize() + "\t" +
                    StringUtils.fromDate(objectSummary.getLastModified()));
    }
    objects = conn.listNextBatchOfObjects(objects);
} while (objects.isTruncated());