import java.util.Scanner;
import java.util.regex.Pattern;

public class Sample
{
    private final static Pattern DIGITS = Pattern.compile( "\\d*" );

    public static void main ( String [] args )
    {
        Scanner scanner = new Scanner( System.in );
        while ( true )
        {
            String input = scanner.nextLine();
            if ( evalInput( input ) )
                process( input );
            else
                System.out.println("Input constraints: it must be just numerical.");
        }
    }

    public static void process ( String str )
    {
        // Whatever you wanna do with the accepted input.
    }

    public static boolean evalInput ( String str )
    {
        if ( str != null && DIGITS.matcher( str ).matches() )
            return true;
        return false;
    }
}