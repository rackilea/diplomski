public void moveFile(String fileName, String bucket, String newFilename, String contentType) throws IOException {
    byte[] bytes = loadFile(bucket, fileName);
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    saveToGcs(bucket, fileName, in, contentType);
}

public byte[] loadFile(String bucket, String fileName) throws IOException {
    GcsFilename gcsFileName = new GcsFilename(bucket, fileName);
    GcsInputChannel readChannel = gcsService.openReadChannel(gcsFileName, 0);
    InputStream in = Channels.newInputStream(readChannel);
    return IOUtils.toByteArray(in);
}

private void saveToGcs(String bucket, String filename, InputStream inputStream, String mimeType) throws IOException {
    GcsFilename gcsFilename = new GcsFilename(bucket, filename);
    GcsFileOptions options = new GcsFileOptions.Builder().mimeType(mimeType).acl("public-read").build();
    GcsOutputChannel writeChannel = gcsService.createOrReplace(gcsFilename, options);
    BufferedOutputStream outputStream = new BufferedOutputStream(Channels.newOutputStream(writeChannel));
    IOUtils.copy(inputStream, outputStream);
    outputStream.close();
    writeChannel.close();
}