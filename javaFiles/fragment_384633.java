class Server {
  private final ClientManager manager = new ClientManager();

  // register new client
  Client newClient() {
    Client client = new Client(manager);
    manager.add(client);
    return client;
  }

  void sendMessageToAll(String msg) {
    for (Client client : manager.list()) {
      // isAlive returns true except if the client was logged out. 
      // It should probably be synchronized too.
      if (client.isAlive()) {
        client.sendMessage(msg);
      }
    }
  }
}

class Client {
  private final ClientManager manager;

  public Client(ClientManager manager) {
    this.manager = manager;
  }

  public void logoff() {
    manager.remove(this);
  }
}