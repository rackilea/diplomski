import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class tokenize
{
    public static List<String> readFile( String fileName )
    {
        FileInputStream fileStrm = null;
        InputStreamReader reader = null;
        BufferedReader buffReader = null;
        List<String> tokens = null;
        try
        {
            // Set up buffered reader to read file stream.
            fileStrm = new FileInputStream( fileName );
            reader = new InputStreamReader( fileStrm );
            buffReader = new BufferedReader( reader );
            // Line buffer.
            String line;
            // List to store results.
            tokens = new ArrayList<String>(); 

            // Get first line.
            line = buffReader.readLine();
            while( line != null )
            {
                // Add this line to the List.
                tokens.add( line );
                // Get the next line.
                line = buffReader.readLine();
            }
        }
        catch( IOException e )
        {
            // Handle exception and clean up.
            if ( fileStrm != null )
            {
                try { fileStrm.close(); }
                catch( IOException e2 ) { }
            }
        }
        return tokens;
    }

    public static void main( String[] args )
    {
        List<String> tokens = readFile( "foo.txt" );
        // You can use a for each loop to iterate through the List.
        for( String tok : tokens )
        {
            System.out.println( tok );
        }
    }
}