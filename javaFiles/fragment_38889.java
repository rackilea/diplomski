public class Server {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void handleConnection(Socket client) throws IOException {    
        PlayerConnection newPlayer = new PlayerConnection(this, client);
        this.executor.execute(newPlayer);
    }

    // add methods to handle requests from PlayerConnection
}