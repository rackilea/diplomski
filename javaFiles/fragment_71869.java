import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleMapsTest {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://maps.google.com/");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        rd.close();
    }
}