//assignment to i takes 1 operation    
 for(i=0; i < n; i++){ // i++ is executed n times, i < n is executed (n+1) times
    SomeJavaStatment; // n times

    //assignment to j takes 1 operation
    for(j=0; j < 2 * n; j+= 2){  // j+=2 is executed n*n times, j < 2*n is executed n*(n+1) times
        SomeJavaStatment; // n * n times
        SomeJavaStatment; // n * n times
    }
 }