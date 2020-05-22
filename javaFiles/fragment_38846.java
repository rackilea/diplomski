public static void main(String[] args) {
    String bucket = "playground-us-east-1-1234567890";
    AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();

    String prefix = "test";
    for (String key : getObjectsListFromS3(s3, bucket, prefix)) {
        System.out.println(key);
    }
}