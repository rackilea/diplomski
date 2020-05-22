import java.util.*;
import java.io.*;
import java.net.*;
class TCPClient{
    public static void main(String args[]) throws Exception{
        Socket client = new Socket("localhost",4888);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String  display = ""; 
        // ADD A TEST FOR "END" HERE --------------------------------------------->
        while ((display = in.readLine()) != null && !display.equals("END")) {
            System.out.println(display);
        }
        System.out.println("\nChoose a file");
        Scanner src = new Scanner(System.in);
        String ask_file = src.nextLine() + "\n"; // ADD A NEWLINE HERE ----------->
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeBytes(ask_file);
        display = ""; 
        while ((display = in.readLine()) != null) {
            System.out.println(display);
        }
    }
}