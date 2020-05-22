InputSupplier supplier = CharStreams.newReaderSupplier(new InputSupplier() {
        @Override
        public InputStream getInput() throws IOException {
           S3Object object = s3Client.getObject(
             new GetObjectRequest(bucketName, folder + filename));
           return object.getObjectContent();
        }
    }, Charsets.UTF_8);
    String content = CharStreams.toString(supplier);