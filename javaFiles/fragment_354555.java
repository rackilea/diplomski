import javafx.embed.swing.JFXPanel;
import java.net.InetAddress;
import java.net.ServerSocket;

public class YourApp {

public static void main(String[] args) 
{
    try
    {
    socket = new ServerSocket(PORT,0,InetAddress.getByAddress(new byte[] {127,0,0,1}));


    //Everything you need to launch the application in the try
    }catch(Exception g){//Nothing in the catch}
}}