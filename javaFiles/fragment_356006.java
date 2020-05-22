public class FileReader extends InputStreamReader {
    // ...
    public FileReader(String fileName) throws FileNotFoundException {
        super(new FileInputStream(fileName));
    }
    // ...
}