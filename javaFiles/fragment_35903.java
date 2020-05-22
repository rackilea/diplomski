import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javax.swing.SwingWorker;

public class JavaApplication174 {

    public static void main(String[] args) {
        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {

                try {
                    URL google = new URL("http://download.piriform.com/ccsetup320.exe");
                    ReadableByteChannel rbc = Channels.newChannel(google.openStream());
                    FileOutputStream fos = new FileOutputStream("c:/ccsetup320.exe");
                    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return this;
            }
        };
        worker.run();
    }
}