while ( true )
{
    if ( socket.getInputStream().available() != 0 )
    {
      // reading logic goes here.... 
      synchronized ( this )
      {
            String clMessage = dStream.readLine();
            System.out.println( "\n" + clMessage );
            out.println( "Hey the server is sending the message to subscriber" );
       }
     }
     // what shall be done when not reading.
}