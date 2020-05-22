import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public final static int portNumber = 6040;
    public static Socket socket;
    private static PrintWriter pw;
    private static Scanner input;
    /**
     * @param args
     * @throws IOException 
     */
    public static void connect() throws IOException{


        // du kan vælge at bruge inetadressen til at connecte i socketet.
        InetAddress adr = InetAddress.getByName("localhost");
        socket = new Socket("localhost", portNumber);
        input=new Scanner(socket.getInputStream());
        pw = new PrintWriter(socket.getOutputStream());
        pw.println("Connected waiting for input");
        pw.flush();

    }
    /**
     * This method sends the message (that the client(chat person) writes to the user)
     * @param x
     * @throws NullPointerException
     * @throws IOException 
     */
    public void SendChat(String x) throws NullPointerException{
            pw.print(x);
            pw.flush(); 


    }
    public int sendCommando(int id) throws IOException{
        pw.print(id);
        pw.flush();
        /*
         * this part of the program sends a command to the server if the command is 1 then 1 is = Connect.
         * the program then ask the server is the server is full or is it ok to connect? 
         * if the response is not 10 then the program will allow a connection to happen the return type will be the Id of which 
         * the chat person becomes!
         */

        // should the method return 0 the Application will do NOTHING!
        switch (id) {
        case 1:
    int k = reciveCommando();
            if (k== 10) {
                return 10;
            }else if (k < 3) {
                System.out.println("returned k" + k);
                return k;
            }else {

            return 10;
            }
            /*
             * Closes the connection with the server!
             */
        case 3:

            socket.close();
            return 0;

        default:
            return 0;
        }

    }
    /*
     * this method recives a command from the server! the comands can be found in the ChatCommands.txt
     * returns the command as an integer!
     */
    public int reciveCommando() throws IOException{
        Integer i = input.nextInt();
        return i;
    }
    /**
     * Gets a String response from the server. This method i used to create other users and give them the correct username.
     * 
     * @param i
     * @return
     * @throws IOException
     */
    public String getStringResponse(int i) throws IOException {
        pw.print(i);
        pw.flush();
        String x = input.nextLine();
        return x;

    }


}