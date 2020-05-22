import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;

public class MultiThreadedRestConsumer {

    public static void main(String[] args) {
        Thread t1 = new Thread(new POSTRestConsumer({URI Here}, {JSON String Body}, {Map of String, Value For Header attributes});
        t1.start();
        //TODO you can create as many threads to consume REST
    }

}

class POSTRestConsumer implements Runnable {

    private String body;
    private String uri;
    private Map<String, String> header;

    public POSTRestConsumer(String uri, String body, Map<String, String> header) {
        this.uri = uri;
        this.body = body;
        this.header = header;
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            // open connection
            connection = (HttpURLConnection) new URL(uri).openConnection();

            // set header
            for (Entry<String, String> entry : header.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            // ensure to set required header if not supplied already
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // set body
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(body.getBytes("UTF-8"));
            os.flush();
            os.close();

            // read response
            StringWriter writer = new StringWriter();
            IOUtils.copy(connection.getInputStream(), writer, "UTF-8");
            System.out.println(writer.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // ensure connection is released
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}