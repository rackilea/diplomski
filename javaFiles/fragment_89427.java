public void sendFiles(Channel channel, File...files) {
    ByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
    int fileCount = files.length;
    // Send the file count
    channel.write(allocator.buffer(4).writeInt(fileCount));
    // For each file
    Arrays.stream(files).forEach(f -> {         
        try {
            // Get the file content
            byte[] content = Files.readAllBytes(f.toPath());
            byte[] fileName = f.getAbsolutePath().getBytes(UTF8);
            // Write the content size, filename and the content
            channel.write(allocator.buffer(4 + content.length + fileName.length)
                    .writeInt(content.length)
                    .writeInt(fileName.length)
                    .writeBytes(fileName)
                    .writeBytes(content)
            );
        } catch (IOException e) {
            throw new RuntimeException(e); // perhaps do something better here.
        }           
    });
    // Flush the channel
    channel.flush();
}