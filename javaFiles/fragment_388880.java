import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLGet {
        public static void main(String[] args) {
                try {
                        URL url = new URL(args[0]);
                        URLConnection urlConnection = url.openConnection();
                        try (
                                InputStream stream = urlConnection.getInputStream();
                        ) {
                                byte[] buf = new byte[4096];
                                int read;
                                while ((read = stream.read(buf, 0, buf.length)) > 0) {
                                        System.out.write(buf, 0, read);
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace(System.err);
                }
        }
}