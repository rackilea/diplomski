public class FileParserFactory {

 private Map<String, FileParser> fileParsers;
 private FileParser defaultParser;

 FileParser getParserInstance(String fileType) {
 if(fileParsers.containsKey(fileType))
          return fileParsers.get(fileType);
        else 
          return defaultParser;
}
public void setParsers(Map<String, FileParser> parsers) {
   filePaarsers = parsers;
} 

public void setDefaultParser(FileParser parser) {
   defaultParser = parser;
}
}