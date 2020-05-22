package q46617008;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorksheetExample
{

    public static final Set< String > alphabets = new HashSet<>( );

    public static final Map< String, String > books = new HashMap<>( );

    public final Path file;

    public WorksheetExample( String fileName ) {
        file = Paths.get( "C:", "Path", "To", "Your", fileName );
    }

    static
    {
        alphabets.add( "A" );
        alphabets.add( "B" );
        alphabets.add( "C" );
        alphabets.add( "D" );

        books.put( "Cookbook", "Vishnu" );
        books.put( "JavaBook", "Balaguru" );
        books.put( "MacBook", "Steve" );
    }

    public static void main( String[ ] args ) throws Exception
    {

        WorksheetExample w;

        w = new WorksheetExample( "ApacheExample.xlsx" );
        new ApacheExample( ).build( w );

        w = new WorksheetExample( "JasperExample.xlsx" );
        new JasperExample( ).exportXLSX( w );

        w = new WorksheetExample( "JasperExample.pdf" );
        new JasperExample( ).exportPDF( w );
    }

}