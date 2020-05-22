import java.io.*;
import java.net.*;

public class EchoServer2 {
    static final String loginMessage = "Logged In";

    static final String logoutMessage = "Logged Out";


    public static void main(String[] args) {
        int serverPort = 7; // default port
        String message;

        if( args.length == 1 ) serverPort = Integer.parseInt(args[0]);
        try {
            // instantiates a stream socket for accepting
            // connections
            ServerSocket myConnectionSocket = new ServerSocket(serverPort);
            /**/System.out.println("Daytime server ready.");
            while( true ) { // forever loop
                // wait to accept a connection
                /**/System.out.println("Waiting for a connection.");
                MyStreamSocket myDataSocket = new MyStreamSocket(
                        myConnectionSocket.accept());
                /**/System.out.println("connection accepted");
                boolean done = false;
                while( !done ) {
                    message = myDataSocket.receiveMessage();

                    /**/System.out.println("message received: " + message);

                    if( (message.trim()).equals("400") ) {
                        // Session over; close the data socket.
                        myDataSocket.sendMessage(logoutMessage);
                        myDataSocket.close();
                        done = true;
                    } // end if

                    if( (message.trim()).equals("100") ) {
                        // Login
                        /**/myDataSocket.sendMessage(loginMessage);
                    } // end if

                    if( (message.trim()).equals("200") ) {

                        File outFile = new File("C:\\OutFileServer.txt");
                        myDataSocket.receiveFile(outFile);
                        myDataSocket.sendMessage("File received "+outFile.length()+" bytes");
                    }

                } // end while !done
            } // end while forever
        } // end try
        catch (Exception ex) {
            ex.printStackTrace();
        }
    } // end main
} // end class