import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Scratch {

public static void main(String[] args) throws IOException {
    URL url = new URL("http://url.to.zip");

    InputStream in = url.openStream();
    FileOutputStream out = new FileOutputStream("test.zip");
    byte[] buffer = new byte[1024];
    int read = 0;
    while ((read = in.read(buffer)) >= 0) {
        out.write(buffer, 0, read);
    }
}

}