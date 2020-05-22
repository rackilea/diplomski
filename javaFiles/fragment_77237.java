AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(REGION).build();
byte[] fileContentBytes = content.getBytes(StandardCharsets.UTF_8);
InputStream in = new ByteArrayInputStream(fileContentBytes);
ObjectMetadata metaData = new ObjectMetadata();
metaData.setContentType(contentType);
metaData.setContentLength(fileContentBytes.length);
PutObjectRequest putObjReq = new PutObjectRequest(bucketName, objectKey, in, metaData);
s3.putObject(putObjReq);