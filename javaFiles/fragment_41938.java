public HttpEntity buildPostMultipartDataEntity(String objectKey, byte[] data, String signature, LocalDateTime dateTime) {

    String dateTimeStr = dateTime.format(ofPattern("yyyyMMdd'T'HHmmss'Z'"));
    String date = dateTime.format(ofPattern("yyyyMMdd"));

    return MultipartEntityBuilder
        .create()
        .addTextBody("key", objectKey)
        .addTextBody("Policy", policy)
        .addTextBody("X-Amz-Signature", signature)
        .addTextBody("X-Amz-Algorithm", algorithm)
        .addTextBody("X-Amz-Date", dateTimeStr)
        .addTextBody("X-Amz-Credential", String.format("%s/%s/%s/s3/aws4_request", accessKey, date, region))
        .addBinaryBody("file", data)
        .build();
}