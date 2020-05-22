public static InputStream getResourceAsStream(String fileKey) {
    AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
    S3Object obj = s3Client.getObject(new GetObjectRequest(bucketName, fileKey));
    long length = obj.getObjectMetadata().getInstanceLength();
    //use length
    return obj.getObjectContent();
}