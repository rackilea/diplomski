public int parse_code( byte[] bs )
{
    int intval = 0;
    for( int i = 0; i < 3; i++ )
        intval = intval * 10 + ( bs[ i ] - '0' );
    return intval;
}