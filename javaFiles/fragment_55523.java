public ByteArrayResource readFile() throws IOException {
    try (S3Object object = amazonS3.getObject(new GetObjectRequest(bucketName, key))) {
        byte[] content = IOUtils.toByteArray(object.getObjectContent());
        return new ByteArrayResource(content);
    }
}