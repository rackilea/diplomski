import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) {
        try {
            String webpage = "Insert random webpage here";
            InputStream in = new URL(webpage).openConnection().getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            while (reader.ready())
                System.out.print((char) reader.read());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}