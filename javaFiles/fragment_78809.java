public class ResumeParserFactory {
    public ResumeParser create(String fileType) {
        if (fileType.contains(".pdf") {
           return new PdfResumeParser();            
        } else if (fileType.contains(".doc") {
           return new WordResumeParser();
        } else {
           throw new IllegalArgumentException("Unknown document type: " + fileType);
        }
    }
}