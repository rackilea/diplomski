try (
    final FileSystem fs = getZipFileSystem("/path/to/the.zip");
    final BufferedReader reader = Files.newBufferedReader(fs.getPath("path/to/entry"),
        StandardCharsets.UTF_8);
) {
    // operate on the reader
}