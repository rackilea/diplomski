public void sort( int[] a ) {
    int length = a.length;

    int stepIndex = 0;
    while ( stepIndex < SEQUENCE.length - 1 && SEQUENCE[ stepIndex ] < length / 3 ) {
        stepIndex++;
    }

    while ( stepIndex >= 0 ) {
        int step = SEQUENCE[ stepIndex-- ];
        for ( int i = step; i < length; i++ ) { // DIFF: i++ instead of i+=step
            for ( int j = i; j >= step && a[ j ] < a[ j - step ]; j -= step ) {
                exch( a, j, j - step );
            }
        }
    }
}