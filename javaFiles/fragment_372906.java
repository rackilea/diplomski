public class Server {

    public static void main(String[] args) {
        ServerSocket server = new ServerSocket(4444);

        while(true) {
            new ServerThread(server.accept()).start();
        }
    }
}