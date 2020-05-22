import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class TestApp {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://download.piriform.com/ccsetup320.exe");
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream("c:/ccsetup320.exe");
            fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}