public static void main( String[] args )
{
    int line = Integer.parseInt( args[ 0 ] );
    int i = 0;
    StringBuffer sb = new StringBuffer();
    while ( i < line )
    {
        double first_input = StdIn.readDouble();
        double second_input = StdIn.readDouble();
        double third_input = StdIn.readDouble();
        double average = first_input * 0.2 + second_input * 0.4 + third_input * 0.4;
        sb.append( average );
        sb.append( " is..\n" );
        line -= 1;
    }
    StdOut.println( sb.toString() );
}