public class ProcessImageData {

    private final File newImageDataTextFile;

    public ProcessImageData(final File newImageDataTextFile) {
        this.newImageDataTextFile = newImageDataTextFile;
    }

    public void execute() throws Exception{
        try (PrintWriter writer = new PrintWriter(newImageDataTextFile)) {
            LineIterator inputFileIterator = FileUtils.lineIterator(
                newImageDataTextFile, StandardCharsets.UTF_8.displayName()
             );
            while (inputFileIterator.hasNext()) {
                writer.println(inputFileIterator.nextLine());
            }
        }
    }
}