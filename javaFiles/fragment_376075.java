public static String intToString( int n ) {
    if ( n == 0 ) {
        return "0";
    } else if ( n < 0 ) {
        return "-" + intToString( -n );
    } else if ( n < 10 ) {
        return "" + (n%10);
    } else {
        return intToString(n/10) + (n%10);
    }
}