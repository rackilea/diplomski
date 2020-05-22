void distributeMessage(String message) {
    List<ConnectionHandler> clientsCopy;
    synchronized (lock) {
        clientsCopy = new ArrayList<>(clients);
    }
    for (ConnectionHandler client : clientsCopy) {
        client.sendMessage(message);
    }
}