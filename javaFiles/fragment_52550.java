public class ConnectionHolder {

    private static ConnectionHolder holder;
    private Client transClient = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ESHost, 9300));

    private ConnectionHolder() {   }

    static ConnectionHolder getInstance() {
        return holder == null ? holder = new ConnectionHolder() : holder;
    }

    public Client getClient() {
        return transClient;
    }

}