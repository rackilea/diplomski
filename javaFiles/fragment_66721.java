// Set the default pipeline options so the various filesystems are
// loaded into the registry. This shouldn't be necessary if used
// within a pipeline.
FileSystems.setDefaultPipelineOptions(PipelineOptionsFactory.create());

// List Bucket
MatchResult listResult = FileSystems.match("gs://filesystems-demo/**/*");
listResult
    .metadata()
    .forEach(
        metadata -> {
          ResourceId resourceId = metadata.resourceId();
          System.out.println(resourceId.toString());
        });


// Read file
ResourceId existingFileResourceId = FileSystems
    .matchSingleFileSpec("gs://filesystems-demo/test-file1.csv")
    .resourceId();

try (ByteArrayOutputStream out = new ByteArrayOutputStream();
    ReadableByteChannel readerChannel = FileSystems.open(existingFileResourceId);
    WritableByteChannel writerChannel = Channels.newChannel(out)) {
  ByteStreams.copy(readerChannel, writerChannel);

  System.out.println("File contents: \n" + out.toString());
}


// Write file
String contentToWrite = "Laces out Dan!";

ResourceId newFileResourceId = FileSystems
    .matchNewResource("gs://filesystems-demo/new-file.txt", false);

try (ByteArrayInputStream in = new ByteArrayInputStream(contentToWrite.getBytes());
    ReadableByteChannel readerChannel = Channels.newChannel(in);
    WritableByteChannel writerChannel = FileSystems.create(newFileResourceId, MimeTypes.TEXT)) {

  ByteStreams.copy(readerChannel, writerChannel);
}