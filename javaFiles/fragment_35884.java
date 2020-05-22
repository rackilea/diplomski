public Upload uploadAsyncFileToS3(String fileName, String fileContent) throws FileAlreadyExistsInS3Exception {
        if (s3client.doesObjectExist(bucketName, fileName)) {
            throw new FileAlreadyExistsInS3Exception(ErrorMessages.FILE_ALREADY_EXISTS_IN_S3.getMessage());
        }
        InputStream targetStream = new ByteArrayInputStream(fileContent.getBytes());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileContent.getBytes().length);
        return transferManager.upload(bucketName, fileName, targetStream, metadata);
}