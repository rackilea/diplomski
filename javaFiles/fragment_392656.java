public static <E> ArrayList< E > union( ArrayList< E > array1, ArrayList< E > array2 ) {
    // arrayUnion will be the arrayList that will be returned
    ArrayList< E > arrayUnion = new ArrayList< E >( array1 );
    arrayUnion.addAll( array2 );
    E current;

    for ( int i = 0; i < arrayUnion.size( ); i++ ) {

        for ( int j = 0; j < arrayUnion.size( ); j++ ) {
            current = arrayUnion.get( i );

            if ( i != j && current.equals( arrayUnion.get( j ) ) ) {
                arrayUnion.remove( j );
                --j;// This is set to check the item which replace the removed item at previous statement
            }
        }
    }

    return arrayUnion;
}