import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
    static ServerSocket serverSocket;
    static Socket socket;
    static PrintWriter printWriter;
    static BufferedReader bufferedReader;
    static Thread thread;

    public static void main(String args[]) throws Exception {
        StudentServer studentServer = new StudentServer();
        studentServer.serverStartActionPerformed();
        studentServer.run("server");
    }

    public void run(String commandMessage) {
        if (true) {
            try {
                printWriter.println(commandMessage);
                String input = bufferedReader.readLine();// reads the input from textfield
                System.out.println("Client message: " + input);// Append to TextArea
            } catch (Exception e) {
            }
        }
    }

    public void serverStartActionPerformed() {
        System.out.println("Server has started!");
        try {
            serverSocket = new ServerSocket(8888); // socket for the server
            socket = serverSocket.accept(); // waiting for socket to accept client
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // reads
                                                                                                 // line
                                                                                                 // from
                                                                                                 // input
                                                                                                 // streamer
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Server not running!"); // print message if server is not running
        }
    }
}