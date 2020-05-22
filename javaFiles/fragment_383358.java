new ByteSource() {
      @Override public InputStream openStream() throws IOException {
        S3Object object = s3Client.getObject(
            new GetObjectRequest(bucketName, folder + filename));
        return object.getObjectContent();
      }
    }.asCharSource(Charsets.UTF_8).read();