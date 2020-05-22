import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) {
        try {
            new EchoServer(INSERTPORT).execute();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private ServerSocket serverSocket;
    private int port;

    private ArrayList<Client> clientList;
    private ExecutorService clientRunner;

    public EchoServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        clientRunner = Executors.newCachedThreadPool();
        clientList = new ArrayList<>();
    }

    public void sendMessageToAll(String message) {
        for (Client c : clientList) {
            c.displayMessage(message);
        }
    }

    public void execute() throws IOException {
        while (true) {
            clientList.add(new Client(serverSocket.accept(), this));
            clientRunner.execute(clientList.get(clientList.size()-1));
        }
    }
    private class Client implements Runnable {

        private Socket clientSocket;
        private Scanner input;
        private Formatter output;

        public Client(Socket s) throws IOException {
            clientSocket = s;

            input = new Scanner(clientSocket.getInputStream());
            output = new Formatter(clientSocket.getOutputStream());
        }

        public void displayMessage(String s) {
            output.format(s + "\n");
            output.flush();
        }
        @Override
        public void run() {
            while(clientSocket.isConnected()) {
                if(input.hasNextLine()) {
                    sendMessageToAll(input.nextLine());
                }
            }
        }
    }
}