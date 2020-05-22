import java.util.Arrays;

public class QuestionMarkQuantifier {
    public static void main(String[] args) {
        final String input = "a:b:c:d:e:f:g:h";
        for ( int i = 1; i <= input.length(); i += 2 ) {
            final String string = input.substring( 0, i );
            System.out.println( "\n== Splits for "+string+" ===" );
            System.out.println( Arrays.toString( string.split( ":", 6 )));
        }
    }
}