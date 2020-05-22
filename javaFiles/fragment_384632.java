class ClientManager {
  private final List<Client> clients;

  public ClientManager() {
    this.clients = new ArrayList<>();
  }

  public synchronized void add(Client client) {
    this.clients.add(client);
  }

  public synchronized void remove(Client client) {
    this.clients.remove(client);
  }

  public synchronized List<Client> list() {
    return new ArrayList<>(this.clients);
  }

}