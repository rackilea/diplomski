public class XMLReader implements FileReader {
        static {
            Registry.register( "xml", new XMLReader() );
        }
....
public class ExcelReader implements FileReader {
        static {
            Registry.register( "xls", new ExcelReader() );
        }
...