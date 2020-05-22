import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class API {
    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpGet request = new HttpGet("http://mirror.rackspace.com/archlinux/iso/2019.12.01");
        URI uri = new URIBuilder(request.getURI())
                .setParameter("info_hash", "foo")
                .setParameter("peer_id", "bar")
                .build();
        request.setURI(uri);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request);
        InputStream input = response.getEntity().getContent();
        String content = IOUtils.toString(input);
        System.out.println(content);
    }
}