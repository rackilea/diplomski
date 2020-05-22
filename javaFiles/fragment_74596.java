public static int prime2( final int n ) {
    int count;
    if ( n <= 2 ) {
        count = 1;
    } else {
        count = prime2(n-1);
        if ( isPrime(n) ) {
            count = count + 1;
        }
    }
    return count;
}