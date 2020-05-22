import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestCount {

    public static void main( String[] args ) {

        String myString = "abc abc abc abc aaabbbccc 0000 *&% a";
        int whiteSpace = 0;
        int textual = 0;
        int numerical = 0;
        int symbols = 0;

        char[] data = myString.toCharArray();
        Arrays.sort( data );

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for ( char c : data ) {
            if ( countMap.containsKey( c ) ) {
                countMap.put( c, countMap.get( c ) + 1 );
            } else {
                countMap.put( c, 1 );
            }
        }

        for ( Map.Entry<Character, Integer> e : countMap.entrySet() ) {

            char key = e.getKey();
            System.out.printf( "%c -> %d occurences\n", e.getKey(), e.getValue() );

            if ( ( key >= 'a' && key <= 'z' ) || ( key >= 'A' && key <= 'Z' ) ) {
                textual += e.getValue();
            } else if ( key >= '0' && key <= '9' ) {
                numerical += e.getValue();
            } else if ( key == ' ' ) {
                whiteSpace += e.getValue();
            } else {
                symbols += e.getValue();
            }

        }

        System.out.printf( "%d are textual characters\n", textual );
        System.out.printf( "%d are numerical characters\n", numerical );
        System.out.printf( "%d are whitespace characters\n", whiteSpace );
        System.out.printf( "%d are symbol characters\n", symbols );

    }

}