import java.io.*;
import java.net.*;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);

            s.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}