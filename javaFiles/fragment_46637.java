while (listofpeers.size() <= _svconfig.getCLIENTSNumber()) {
   Socket _clientsocket = _serversocket.accept();
   ServerPeer _serverpeer = new ServerPeer(_clientsocket);
   _serverpeer.start();
   listofpeers.add(_serverpeer);
}
_serversocket.close();