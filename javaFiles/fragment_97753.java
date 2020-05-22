public class App {

    public static void main(String[] args) {    
           AccountReader accountReader = new AccountReader();  
           List<AccountInfo> accounts = accountReader.read(args); 
           // maybe do something with those accounts?                         
    }
}

public class AccountReader {

    private ParseXML parseXML;

    public AccountReader() {
         this.parseXML = new ParseXML();
    }

    // extra constructor to allow dependency injection from test
    protected AccountReader(ParseXML parseXML) {
         this.parseXML = parseXML;
    }

    public List<AccountInfo> read(String[] args) {          
           return parseXML.ParseAccounts(getFileName(args));          
    }

    private String getFileName(String[] args) {
        List<String> arguments = Arrays.asList(args);          
        int importIndex = arguments.indexOf("Import");    
        if (importIndex < 0) {
            throw new RuntimeException("Missing Import argument");
        }        
        int fileNameIndex = importIndex + 1;
        if (fileNameIndex >= arguments.size()) {
            throw new RuntimeException("Missing fileName argument");
        }
        String fileName = args[fileNameIndex];
        if (!fileName.endsWith(".xml")) {
            throw new RuntimeException("Can only import XML files");
        } 
        return fileName;  
    }

}