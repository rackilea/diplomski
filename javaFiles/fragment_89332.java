Process p = Runtime.getRuntime().exec( "ls -l" );
p.waitFor();

BufferedReader reader = new BufferedReader( new InputStreamReader( p.getInputStream() ) );

String line = "";
while ((line = reader.readLine())!= null) {
    System.out.println( "line : " + line);
}