synchronized ( this )
      {
        String clMessage = dStream.readLine();
        System.out.println( "\n" + clMessage );
        out.println( "Hey the server is sending the message to subscriber" );
        mrl.onMessageReceived( clMessage );
      }