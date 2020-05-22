String getS3FileHash(AmazonS3 amazonS3, String s3bucket, String filePath) {
    try {
        InputStream inputStream = amazonS3.getObject(s3bucket, filePath).getObjectContent();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest);
        byte[] buffer = new byte[4096];
        int count = 0;
        while (digestInputStream.read(buffer) > -1) {
            count++;
        }
        log.info("total read: " + count);
        MessageDigest digest = digestInputStream.getMessageDigest();
        digestInputStream.close();
        byte[] md5 = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b: md5) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString().toLowerCase();
    } catch (Exception e) {
        log.error(e);
    }
    return null; 
}