public class Test {
    public static void main(String[] args) throws Exception {
        ServerSocket listen = new ServerSocket(9999);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        while(true) {
            Socket client = null;
            try {
                client = listen.accept();
            } catch(IOException e) {
                System.err.println(e);
            }
            System.out.println("New connection from client: " +
                    client.getInetAddress().getHostAddress() + "\n"
            );

            threadPool.execute(new ConnectionHandler(client));
        }
    }
}

class ConnectionHandler implements Runnable {
    private Socket client;

    public ConnectionHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            String input;
            while(true) {
                input = in.readLine();
                if(input == null)
                    break;

                out.write(input);
                out.newLine();
                out.flush();
            }
        } catch(IOException e) {
            System.err.println("Error from socket IO.");
        }

        try {
            client.close();
        } catch(IOException e) {
            System.err.println("Error when closing socket.");
        }
        System.out.println("Client " + client.getInetAddress().getHostAddress() +
                " closed connection.\n");
    }
}