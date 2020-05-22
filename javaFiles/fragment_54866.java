class ClientManager {
    private Hashtable<String, Client> clientMap = new Hashtable<>();

    public void sendGlobalMessage(String message) {
        for(Client client : clientMap.values()) {
            if(client != null) {
                client.sendMessage(message);
            }
        }
    }
}