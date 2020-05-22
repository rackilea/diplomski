import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadedClient {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java ThreadedClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            Socket serverSocket = new Socket(hostName, portNumber);
            ClientServerOutputReader csor = new ClientServerOutputReader(serverSocket);
            csor.start();
            ClientUserInputReader cuir = new ClientUserInputReader(serverSocket);
            cuir.start();
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        } 
    }

}

class ClientServerOutputReader extends Thread {
    Socket serverSocket;
    public ClientServerOutputReader(Socket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
            new InputStreamReader(serverSocket.getInputStream()));

            String outputFromServer="";
            while((outputFromServer=in.readLine())!= null){
                //This part is printing the output to console
                //Instead it should be appending the output to some file
                //or some swing element. Because this output may overlap
                //the user input from console
                System.out.println(outputFromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ClientUserInputReader extends Thread {
    Socket serverSocket;
    public ClientUserInputReader(Socket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void run(){
        BufferedReader stdIn = new BufferedReader(
                 new InputStreamReader(System.in));
        PrintWriter out;
        try {
            out = new PrintWriter(serverSocket.getOutputStream(), true);
            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}