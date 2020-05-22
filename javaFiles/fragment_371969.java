long count = 1L;
    for( int i=0; i<n; i++ ) count *= MAX;

    ...

    int[] digits = new int[n];
    char[] output = new char[n];
    Arrays.fill( output, '0' );

    ...

            for(int d = n-1; d >=0; --d){