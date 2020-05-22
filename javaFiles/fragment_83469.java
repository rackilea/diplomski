void f2() {
        int foo=0;                                  // selection start
        double[] bar = new double[10];
        for ( int i = 0 ; i < bar.length ; i++ ) {
            bar[i] = foo;
        }
        foo = 0;                                    // selection end
    }