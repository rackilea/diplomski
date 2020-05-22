AWSCredentials credentials = new BasicAWSCredentials(appId,appSecret);
  AmazonS3 s3Client = new AmazonS3Client(credentials);

  GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest("YOUR_BUCKET_NAME", "FOLDER_INSIDE_BUCKET/YOUR_FILE.pdf");

  generatePresignedUrlRequest.setMethod(HttpMethod.GET); 

  Date expiration = new Date();
  long milliSeconds = expiration.getTime();
  milliSeconds += 1000 * 60 * 60; // Add 1 hour.
  expiration.setTime(milliSeconds);
  generatePresignedUrlRequest.setExpiration(expiration);
  URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest); 
  String finalUrl  = url.toString();