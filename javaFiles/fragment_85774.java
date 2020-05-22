@Test
public void testCreateTempFile() throws IOException {
    FileSystem fs = Jimfs.newFileSystem();

    Path tempDir = fs.getPath("mytempdir");
    String prefix = "myprefix";
    String suffix = ".tmp";

    byte[] data = new byte[1];
    data[0] = 0x66;

    TempFileWriter tempFileWriter = new TempFileWriter(tempDir, prefix, suffix);
    tempFileWriter.writeToTempFile(data);

    Files.list(tempDir).forEach(path -> {
        String fileName = path.getName(0).toString();
        assertTrue(fileName.startsWith(prefix));
        assertTrue(fileName.endsWith(suffix));
        assertTrue(Files.readAllBytes(path)[0] == 0x66)
    });
}