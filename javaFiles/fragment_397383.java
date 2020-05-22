import java.util.Scanner;
import java.util.TreeSet;

public class LexicographicScanner {

    private final TreeSet<String> words = new TreeSet<String>();

    public LexicographicScanner( final Scanner scanner )
    {
        while ( scanner.hasNext() )
        {
            words.add( scanner.next() );
        }
        scanner.close();
    }

    public String nextWord( final String word )
    {
        return words.higher( word );
    }

    public static void main(String[] args) {
        final LexicographicScanner ls
            = new LexicographicScanner ( new Scanner("I am very happy with life") );

        System.out.println( ls.nextWord( "am" ) );
        System.out.println( ls.nextWord( "I" ) );
        System.out.println( ls.nextWord( "with" ) );
    }
}