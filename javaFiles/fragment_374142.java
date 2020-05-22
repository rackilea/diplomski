Path path = Files.createTempFile(filename, suffix);
file = path.toFile();

Files.write(path, incomingXml.getBytes(StandardCharsets.UTF_8));

if(file!=null){
    s3client.putObject(new PutObjectRequest(fullBucketPathByDate, filename, file));
    file.delete();
}
LOGGER.info("Upload completed");