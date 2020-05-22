public static void main(String[] args) {
    int x = 0;
    int y = 0;
    int size = 4;

    for ( int i = -1; i <= 1; ++i ) {
        for ( int j = -1; j <= 1; ++j ) {
            if ( i != 0 || j != 0 ) {
                int xij = getCoord( x, i, size );
                int yij = getCoord( y, j, size );
                System.out.println( "x=" + xij + "  y=" + yij );
            }
        }
    }

}