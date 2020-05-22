public static void printNumbers ( int n )
{
    if ( n > 0 )
    {
        printNumbers( n - 1 ); // n - 2, if the "i++" within the for loop is intended
        System.out.println( n );
    }
}