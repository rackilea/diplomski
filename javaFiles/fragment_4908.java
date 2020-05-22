public class SocketClient {

    private static SocketClient sClient;

    private SocketClient() {

    }

    public synchronized static SocketClient getInstance() {
        if (sClient == null) {
            sClient = new SocketClient();
        }
        return sClient;
    }

    public void connect() {
        //Your connection code will come here
    }

    public void disconnect() {
        //Your disconnection code will come here
    }

    public void sendMessage(String message) {
        // message sending will code 
    }

}