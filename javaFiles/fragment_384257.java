import java.io.*;
import java.net.*;

public class SocketTest {
    public static void main(String[] args) {
        String hostName;
        int i = 0;
        try {
            Socket socketClient = new Socket("whois.internic.net", 43);
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            OutputStream out = socketClient.getOutputStream();
            System.out.println("Please Enter the Host Name!!");
            hostName = bf.readLine();
            hostName = hostName + "\n";
            byte[] buf = hostName.getBytes();
            out.write(buf);

            InputStream in = socketClient.getInputStream();
            while ((i = in.read()) != -1) {
                System.out.print((char) i);
            }
            in.close();
            out.close();
            socketClient.close();

        } catch (UnknownHostException uht) {
            System.out.println("Host Error");
        } catch (IOException ioe) {
            System.out.println("IO Error " + ioe);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}