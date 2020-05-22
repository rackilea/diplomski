private static void print( int n ){
    print( n/10, n%10 );
}

private static int print( int n, int ld ){
    if( n < 10 ) return n;
    int digit = n % 10;
    int first = print( n/10, ld );
    if( digit < ld && digit > first )
        System.out.println( digit );
    return first;
}