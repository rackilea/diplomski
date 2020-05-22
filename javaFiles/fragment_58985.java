public class Main {

private static final String PACKAGE = "generated";
private static final String SCHEMA  = "table.xsd";
private static final String XMLIN   = "database.xml";

private Database db;

void unmarshal() throws Exception {
    JAXBContext jc = JAXBContext.newInstance( PACKAGE );
    Unmarshaller m = jc.createUnmarshaller();

    JAXBElement<Database> jbe = null;
    try {
        StreamSource source =
            new StreamSource( new FileInputStream( XMLIN ) );
        jbe = m.unmarshal( source, Database.class );
        db = jbe.getValue();
    } catch( Exception e  ){
        System.out.println( "EXCEPTION: " + e.getMessage() );
        e.printStackTrace();
}
}

public Database getDatabase(){
    return db;
}

public static void main( String[] args ) {
    Main main = new Main();
    try {
        main.unmarshal();
        Database db = main.getDatabase();
        for( Table table: db.getTable() ){
            for( Column column: table.getColumn() ){
                 for( String cell: column.getCell() ){
                     System.out.print( " " + cell );
                }
            } 
        }       
    } catch( Exception e ){
        System.err.println( "marshal fails: " );
        e.printStackTrace();
    }
}
}