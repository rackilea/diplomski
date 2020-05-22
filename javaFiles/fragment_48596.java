AWSCredentials credentials = new BasicAWSCredentials(appId,appSecret);
    AmazonS3 s3Client = new AmazonS3Client(credentials);

    String bucketPath = "YOUR_BUCKET_NAME/FOLDER_INSIDE_BUCKET";
    InputStream is = new FileInputStream("YOUR_PDF_FILE_PATH");
    ObjectMetadata meta = new ObjectMetadata();
    meta.setContentLength(is.available());
    s3Client.putObject(new PutObjectRequest(bucketPath,"YOUR_FILE.pdf", is, meta).withCannedAcl(CannedAccessControlList.Private));