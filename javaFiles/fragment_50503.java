InputStream cpResource = this.getClass().getClassLoader().getResourceAsStream("file.name");
File tmpFile = File.createTempFile("file", "temp");
FileUtils.copyInputStreamToFile(cpResource, tmpFile); // FileUtils from apache-io
try {
    decider.load(tmpFile);
} finally {
    tmpFile.delete();
}