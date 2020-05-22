private static int[] data () {
    return new int[] { ... the same data as in the OP ... };
}

public static void main(String[] args) {
    if ( args.length == 0 || args [ 0 ].equals ( "bubble" ) ) {
        for ( int i = 0; i < 1000; ++i ) {
            int[] data = data();
            bubbleSort ( data );
        }
    } else if ( args [ 0 ].equals ( "none" ) ) {
        for ( int i = 0; i < 1000; ++i ) {
            int[] data = data();
        }
    } else if ( args [ 0 ].equals ( "quick" ) ) {
        for ( int i = 0; i < 1000; ++i ) {
            int[] data = data();
            quickSort( data, 0, data.length-1 );
        }
    } else if ( args [ 0 ].equals ( "quick_op" ) ) {
        for ( int i = 0; i < 1000; ++i ) {
            int[] data = data();
            quickSort_op( data, 0, data.length-1 );
        }
    }
}