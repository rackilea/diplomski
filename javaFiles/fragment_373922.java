try {

    //write message to server

} catch ( SocketException e ) {

    //we lost the connection, so let's try to reconnect
    while ( true ) {
        try {
            socketToDestiny.connect( ...ip address ... );
            break; 
        } catch ( IOException e2 ) {

            //keep trying to reconnect!
            continue;
        }
    }
}