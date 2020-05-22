public static String intToString( int n ) {
    if ( n == 0 ) {
        return "0";
    } else if ( n < 0 ) {
        return "-" + positiveIntToString( -n );
    } else {
        return positiveIntToString(n);
    }
}

private static String positiveIntToString( int n ) {
    if ( n == 0 ) {
        return "";
    } else {
        return positiveIntToString( n / 10 ) + ( n % 10 );
    }
}