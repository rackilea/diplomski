// New constructor since we will pass a Listener now. Also new local variable for it.
public Server( Socket socket, int clientNumber, MessageReceivedListener mrl )
  {
    this.socket = socket;
    this.clientNumber = clientNumber;
    this.mrl = mrl;
    if ( socket.getLocalPort() == 5000 )
      System.out.print( "\nSubscriber " + clientNumber + " is connected to the server" );
    if ( socket.getLocalPort() == 8000 )
      System.out.print( "\nPublisher " + clientNumber + " is connected to the server" );
  }