ServerSocket _serversocket = new ServerSocket(_mysocket, _svconfig.getCLIENTSNumber());
boolean alive = true;
while (alive) {

    try {
        //Keep accepting connection request
        Socket clientRequest = _serversocket.accept();

        //Check if too many user are connected
        if (listofpeers.size() <= _svconfig.getCLIENTSNumber()) {
            ServerPeer _serverpeer = new ServerPeer(_clientsocket);
            _serverpeer.start();
            listofpeers.add(_serverpeer);
        }else{
            //Reject connection if too many connected
            clientRequest.close();
        }
    } catch (Throwable t) {
        t.printStackTrace();
    }
}
//When server dead close it down
_serversocket.close();