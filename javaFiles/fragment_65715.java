import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FileStoreApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:9000")
public class FileStoreRestServiceTest {
    private static Logger logger = LoggerFactory.getLogger(FileStoreRestServiceTest.class);
    protected final Log logger2 = LogFactory.getLog(getClass());

    String base = "http://localhost:9000/filestore";
    private RestTemplate restTemplate = new TestRestTemplate();

@Test
public void testMyMethodExecute() throws IOException {
    String content = "This is file contents\nWith another line.\n";
    Path theTestFilePath = TestingUtils.getTempPath(content);
    InputStream inputStream = Files.newInputStream(theTestFilePath);

    String url = base + "/upload";
    final RequestCallback requestCallback = new RequestCallback() {
        @Override
        public void doWithRequest(final ClientHttpRequest request) throws IOException {
            request.getHeaders().setContentType(MediaType.APPLICATION_OCTET_STREAM);
            IOUtils.copy(inputStream, request.getBody());
        }
    };
    final RestTemplate restTemplate = new RestTemplate();
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setBufferRequestBody(false);
    restTemplate.setRequestFactory(requestFactory);
    ClientHttpResponse response = restTemplate.execute(url, HttpMethod.POST, requestCallback,
            new ResponseFromHeadersExtractor());
    URI location = response.getHeaders().getLocation();
    System.out.println("Location: " + location);
    Assert.assertNotNull(location);
    Assert.assertNotEquals(0, location.getPath().length());

}

private static class ResponseFromHeadersExtractor implements ResponseExtractor<ClientHttpResponse> {

    @Override
    public ClientHttpResponse extractData(ClientHttpResponse response) {
        System.out.println("StringFromHeadersExtractor - response headers: " + response.getHeaders());
        return response;
    }
}