import java.io.*;
import java.io.*;
import java.net.*;
import java.util.logging.*;


public class Client {

DataOutputStream os;

public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {

        public void run() {
               Client c = new Client();
        try {
            Socket s = new Socket("localhost", 1111);
            c.os = new DataOutputStream(s.getOutputStream());
            while (true){
                String str = Input.read_string();
                c.os.writeUTF(str);
            }
        } catch ( IOException e) {
            // TODO auto-generated catch block
            e.printStackTrace();
        }
            }
        });
    }
}

public class Input{
    public static String read_string(){
        String read="";
        try{
            read = new BufferedReader(new InputStreamReader(System.in), 1).readLine();
        }catch (IOException ex){
            System.out.println("error reading from the input stream!");
        }
        return read;
    }
}