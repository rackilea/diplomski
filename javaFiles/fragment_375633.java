//...Somewhere in the Server
ArrayList<Thread> clients = new ArrayList<Thread>();

public void addClient() {
  clients.add(new ClientThread());
}

public boolean checkForMessages() {
  for(Thread t : clients)
    if(!t.hasMessage)
      return false;
  return true;
}