import java.io.*;
import java.net.InetAddress;

public class EchoClient2 {

    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        File file = new File("C:\\MyFile.txt");

        try {
            System.out.println("Welcome to the Echo client.\n"
                    + "What is the name of the server host?");
            String hostName = br.readLine();
            if( hostName.length() == 0 ) // if user did not enter a name
                hostName = "localhost"; // use the default host name
            System.out.println("What is the port number of the server host?");
            String portNum = br.readLine();
            if( portNum.length() == 0 ) portNum = "7"; // default port number
            MyStreamSocket socket = new MyStreamSocket(
                    InetAddress.getByName(hostName), Integer.parseInt(portNum));
            boolean done = false;
            String echo;
            while( !done ) {

                System.out.println("Enter Code: 100 = Login, 200 = Upload, 400 = Logout: ");
                String message = br.readLine();
                boolean messageOK = false;

                if( message.equals("100") ) {
                    messageOK = true;
                    System.out.println("Enter T-Number: (Use Uppercase 'T')");
                    String login = br.readLine();
                    if( login.charAt(0) == 'T' ) {
                        System.out.println("Login Worked fantastically");
                    } else {
                        System.out.println("Login Failed");
                    }
                    socket.sendMessage("100");
                }

                if( message.equals("200") ) {
                    messageOK = true;
                    socket.sendMessage("200");
                    socket.sendFile(file);
                }
                if( (message.trim()).equals("400") ) {
                    messageOK = true;
                    System.out.println("Logged Out");
                    done = true;
                    socket.sendMessage("400");
                    socket.close();
                    break;
                }

                if( ! messageOK ) {
                    System.out.println("Invalid input");
                    continue;
                }

                // get reply from server
                echo = socket.receiveMessage();
                System.out.println(echo);
            } // end while
        } // end try
        catch (Exception ex) {
            ex.printStackTrace();
        } // end catch
    } // end main
} // end class