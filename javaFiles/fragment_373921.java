try {

    //write message to server

} catch ( SocketException e ) {

    //we lost the connection, right? then print if the socket is connected
    System.out.println( socketToDestiny.isConnected() );
}