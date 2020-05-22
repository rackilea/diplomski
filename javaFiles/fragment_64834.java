public void printTree( BinaryNode t ) {
    if ( null == t )
        return;
    printTree( t.left );
    System.out.printf( "The variable %s appears at lines ", t.var );
    for ( int l = 0; l < t.count; l++ )
        System.out.printf( "%d ", t.lines[ l ] );
    System.out.println();
    printTree( t.right );
}