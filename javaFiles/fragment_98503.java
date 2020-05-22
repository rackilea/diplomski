private InputStream doRawGET( String url )
{
    Socket s = new Socket( new URL( url ).getHost() , 80 );
    PrintWriter out = new PrintWriter( s.getOutputStream() , true );
    out.println( "GET " + new URL( url ).getPath() + " HTTP/1.0" );
    out.println(); // extra CR necessary sometimes.
    return s.getInputStream():
}