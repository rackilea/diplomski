Scanner input = null;
try
{
    ArrayList<String> list = new ArrayList<String>();
    input = new Scanner( new File("") );
    while ( input.hasNext() )
        list.add( input.nextLine() );
}
finally
{
    if ( input != null )
        input.close();
}