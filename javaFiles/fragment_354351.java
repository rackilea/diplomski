String s = "Hello stack over flow";
    List< String > words = Arrays.asList( s.split( " " ) );
    Collections.reverse( words );
    String reversed = words.get( 0 );
    for ( int i = 1; i < words.size(); ++i ) {
        reversed += " " + words.get( i );
    }