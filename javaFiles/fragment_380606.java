@Service
public class TextfileService {
    public TextfileService() {
        super(getFileAnalyzer(), "c:\logs");
    }
}

private static FileAnalyzer getFileAnalyzer(){
    FileAnalyzer analyzer = new FileAnalyzer();
    analyzer.configure(..);
    return analyzer;
}