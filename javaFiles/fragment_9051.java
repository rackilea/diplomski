try
{
    String line;
    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( dataInputStream ) );
    while( (line = bufferedReader.readLine()) != null )
    { 
        System.out.printf("%s\n", line);
    }  
} 
catch( IOException e )
{
    System.err.println( "Error: " + e );
}