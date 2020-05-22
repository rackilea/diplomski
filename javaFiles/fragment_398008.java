public abstract class FileManager<OUPUT> {
    public abstract OUTPUT readFile();
}

public class CSVFileReader extends FileManager<List<String>> {
    @Override
    public List<String> readFile() {
        // ...
    }
}

public class XLSFileReader extends FileManager<Map<String, String>> {
    @Override
    public Map<String, String> readFile() {
        // ...
    }
}