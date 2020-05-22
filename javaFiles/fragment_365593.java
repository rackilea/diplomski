public class TestCount {

    public static void main( String[] args ) {

        String myString = "abc abc abc abc aaabbbccc 0000 *&% a";
        int whiteSpace = 0;
        int textual = 0;
        int numerical = 0;
        int symbols = 0;

        char[] data = myString.toCharArray();
        mySort( data );

        // a counting array. it will waste a lot of space, but it will work
        int[] countArray = new int[ (int) data[data.length-1] + 1 ];

        for ( char c : data ) {
            countArray[ (int) c ]++;
        }

        char lastChar = '\0';
        for ( char c : data ) {

            if ( c != lastChar ) {
                System.out.printf( "%c -> %d occurences\n", c, countArray[ (int) c ] );
            }

            if ( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) ) {
                textual++;
            } else if ( c >= '0' && c <= '9' ) {
                numerical++;
            } else if ( c == ' ' ) {
                whiteSpace++;
            } else {
                symbols++;
            }

            lastChar = c;

        }

        System.out.printf( "%d are textual characters\n", textual );
        System.out.printf( "%d are numerical characters\n", numerical );
        System.out.printf( "%d are whitespace characters\n", whiteSpace );
        System.out.printf( "%d are symbol characters\n", symbols );

    }

    public static void mySort( char[] array ) {
        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array.length-1; j++ ) {
                if ( array[j] > array[j+1] ) {
                    char t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

}