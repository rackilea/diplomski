public class Main {

    public static void main( String[] args ) {

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        final int mid = ( chars.length + 1 ) / 2;


        System.out.println( "Mid: " + mid );
        System.out.println( "Start : " + new String( chars ) );

        // Pass one : Swap first half chars with last half chars
        if( ( chars.length % 2 ) == 1 ) {
            /* We swap the characters this way because the left half
             *  is one character longer than the right half. To avoid
             *  unnecessary copies we move the right character to
             *  the index before the left character and save the first
             *  character to be placed at the mid point
             */
            char first = chars[ 0 ];
            for( int l = 1, r = mid; r < chars.length; l++, r++ ) {
                chars[ l - 1 ] = chars[ r ];
                chars[ r ] = chars[ l ];
            }
            chars[ mid - 1 ] = first;
        }
        else {
            for( int l = 0, r = mid; r < chars.length; l++, r++ ) {
                swap( chars, l, r );
            }
        }

        System.out.println( "Pass 1: " + new String( chars ) );

        // Pass two: Swap first two chars with last two chars
        swap( chars, 0, chars.length - 2 );
        swap( chars, 1, chars.length - 1 );

        System.out.println( "Pass 2: " + new String( chars ) );

        // Pass three: Swap middle 4 characters.
        swap( chars, mid - 1, mid + 1 );
        swap( chars, mid - 2, mid );

        System.out.println( "Pass 3: " + new String( chars ) );
    }


    public static void swap( char[] chars, int l, int r ) {
        char tmp = chars[ l ];
        chars[ l ] = chars[ r ];
        chars[ r ] = tmp;
    }
}