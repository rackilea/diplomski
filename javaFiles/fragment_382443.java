public class ClientServerMain {

    public static void main(String[] args) {
        Thread server = new Thread(new Server());
        server.start();
        Thread client = new Thread(new Client());
        client.start();
    }
}