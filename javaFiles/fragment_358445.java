package so17380731;

import com.ning.http.client.AsyncHttpClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.ws.rs.core.HttpHeaders;

public class BasicAuth {

    public static void main(String... args) throws Exception {
        try(AsyncHttpClient asyncClient = new AsyncHttpClient()) {
            final String user = "StackOverflow";
            final String password = "17380731";
            final String fetchURL = "https://www.eventick.com.br/api/v1/events/492";
            final String encoded = Base64.getEncoder().encodeToString((user + ':' + password).getBytes(StandardCharsets.UTF_8));
            final String body = asyncClient
                .prepareGet(fetchURL)
                .addHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoded)
                .execute()
                .get()
                .getResponseBody(StandardCharsets.UTF_8.name());
            System.out.println(body);
        }
    }
}