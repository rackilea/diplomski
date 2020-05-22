public void addFile(String source, String destination, Configuration paramConfiguration) throws IOException, URISyntaxException {
    FileSystem localFileSystem = FileSystem.get(paramConfiguration);
    String str1 = paramString1.substring(source.lastIndexOf('/') + 1, source.length());
    if (destination.charAt(destination.length() - 1) != '/') {
        destination = destination + "/" + str1;
    } else {
        destination = destination + str1;
    }
    BZip2Codec localBZip2Codec = new BZip2Codec();
    String str2 = localBZip2Codec.getDefaultExtension();
    Path localPath = new Path(paramString2 + str2);

    CompressionOutputStream localCompressionOutputStream = localBZip2Codec.createOutputStream(localFileSystem.create(localPath));

    IOUtils.copyBytes(localFileSystem.open(new Path(paramString1)), localCompressionOutputStream, 4096, true);
}