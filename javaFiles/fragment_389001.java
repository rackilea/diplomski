import java.net.URI;

import javax.ws.rs.core.UriBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            URI url = UriBuilder.fromUri("www.something.com")
                    .queryParam("q", "{some thing}")
                    .build();
            System.out.println(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}