import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionMarkQuantifier {
    public static void main(String[] args) {
        final String input = "a:b:c:d:e:f:g:h";
        final Pattern p = Pattern.compile( "([^:]*):([^:]*):([^:]*)(?::([^:]*))?(?::([^:]*))?" );
        for ( int i = 1; i <= input.length(); i += 2 ) {
            final String string = input.substring( 0, i );
            final Matcher m = p.matcher( string );
            if ( m.matches() ) {
                System.out.println( "\n=== Matches for: "+string+" ===" );
                final int count = m.groupCount();
                for ( int j = 0; j <= count; j++ ) {
                    System.out.println( j + ": "+ m.group( j ));
                }
            }
            else {
                System.out.println( "\n=== No matches for: "+string+" ===" );
            }
        }
    }
}