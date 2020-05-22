public class TempFileWriter {

    private final Path tempDir;
    private final String prefix;
    private final String suffix;

    public TempFileWriter(Path tempDir, String prefix, String suffix) {
        this.tempDir = tempDir;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public Path writeToTempFile(byte[] value) throws IOException {
        Path tempFile = Files.createTempFile(tempDir, prefix, suffix);
        Files.write(tempFile, value);
        return tempFile;
    }
}