import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StudentClient {
    static Socket socket;
    static PrintWriter printWriter;
    static BufferedReader bufferedReader;
    static Thread thread;

    public void clients() {
        try {
            socket = new Socket("localhost", 8888);// Socket for client
            // below line reads input from InputStreamReader
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // below line writes output to OutPutStream
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected");// debug code
        } catch (Exception e) {
            System.out.println("Not Connected");
        }
    }

    public void run(String commandMessage) {
        if (true) {
            try {
                String input = bufferedReader.readLine();
                System.out.println("From server:" + input);
                printWriter.println(commandMessage);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) throws Exception {
        StudentClient studentClient = new StudentClient();
        studentClient.clients();
        studentClient.run("client");
    }
}