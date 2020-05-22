import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MulticastEchoServer {
    List<Client> clientList = new LinkedList<Client>();
    ExecutorService executor;

    int port = 40480;
    int max = 10;

    public MulticastEchoServer() {
        this.executor = Executors.newFixedThreadPool(max);
    }

    public void writeToAllClients(String string) throws IOException {
        // Multiple threads access this so it must be in synchronized block
        synchronized (this.clientList) {
            Iterator<Client> iter = this.clientList.iterator();
            while (iter.hasNext())
                iter.next().write(string);
        }
    }

    public void addClient(Client client) {
        // Multiple threads access this so it must be in synchronized block
        synchronized (this.clientList) {
            clientList.add(client);
        }
    }

    public void removeClient(Client client) {
        // Multiple threads access this so it must be in synchronized block
        synchronized (this.clientList) {
            clientList.remove(client);
        }
    }

    public void listen() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("server started and listening for connections");

            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.print("connection accepted" + "\n");

                    Client newClient = new Client(this, socket);

                    this.addClient(newClient);
                    this.executor.execute(newClient);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MulticastEchoServer().listen();
    }

    private class Client implements Runnable {

        Socket socket;
        PrintWriter writer;
        BufferedReader reader;
        MulticastEchoServer server;

        public Client(MulticastEchoServer server, Socket socket) throws IOException {
            this.server = server;
            this.socket = socket;
            this.writer = new PrintWriter(this.socket.getOutputStream());
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        synchronized public void write(String string) throws IOException {
            writer.write(string);
            writer.flush();
        }

        public void close() {
            this.writer.close();
            try {
                this.reader.close();
            } catch (IOException e) {
            }
            try {
                this.socket.close();
            } catch (IOException e) {
            }
        }

        @Override
        public void run() {
            System.out.println("Client Waiting");

            String inString = null;
            try {
                while ((inString = this.reader.readLine()) != null) {
                    this.server.writeToAllClients(inString + "\n");
                    System.out.println(inString);
                }
            } catch (IOException e1) {
            }

            server.removeClient(this);
            this.close();
            System.out.println("Client Closed");
        }
    }

}