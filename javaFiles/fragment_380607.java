@Service
public class TextfileService {
    public TextfileService() {
        super(new FileAnalyzer().configure(...), "c:\logs");
    }
}