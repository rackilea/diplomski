@FunctionName("blobprocessor")
public void run(
    @BlobTrigger(name = "file",
                 dataType = "binary",
                 path = "myblob/{name}",
                 connection = "MyStorageAccountAppSetting") byte[] content,
    @BindingName("name") String filename,
    final ExecutionContext context
) {
    context.getLogger().info("Name: " + filename + " Size: " + content.length + " bytes");
}