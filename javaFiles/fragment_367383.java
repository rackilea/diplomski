byte[] contents = IOUtils.toByteArray(inputStream);
InputStream stream = new ByteArrayInputStream(contents);

ObjectMetadata meta = new ObjectMetadata();
meta.setContentLength(contents.length);
meta.setContentType("image/png");

s3client.putObject(new PutObjectRequest(
        bucketName, fileName, stream, meta)
        .withCannedAcl(CannedAccessControlList.Private));

inputStream.close();