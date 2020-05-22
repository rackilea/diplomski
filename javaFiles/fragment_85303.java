BufferedReader bufferedReader = new BufferedReader( new FileReader( "absolute file path" ) );

String line;

while ( ( line = bufferedReader.readLine() ) != null)
{
     System.out.println( line );
}