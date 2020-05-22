socket = server.accept();
ConnectionHandler client = new ConnectionHandler(this, socket)
synchronized (lock) {
    clients.add(client);
}
new Thread(client).start();