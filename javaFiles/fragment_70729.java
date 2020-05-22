public Solution runAlgorithm( String method, int duration )
    Solution solution = null;
    if ( method.equals( "time" ) {
        long start = System.currentTimeMillis();
        while ( true ) {
            if ( System.currentTimeMillis() - start > duration ) {
                break;
            }
            // do stuff
        }
    }
    else {
        for ( int iter = 0; iter < 100; iter++ ) {
            // do stuff
        }
    }
    return solution;
}