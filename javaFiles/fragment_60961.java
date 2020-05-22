import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipartResponseTest extends JerseyTest {

    public static class Model {
        private String value;
        public Model() {}
        public Model(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }

    @Path("test")
    public static class TestResource {
        @GET
        @Produces(MediaType.MULTIPART_FORM_DATA)
        public Response get() throws Exception {
            final MultiPart multiPart = new FormDataMultiPart()
                    .field("json-data", new Model("Test Value"), MediaType.APPLICATION_JSON_TYPE)
                    .bodyPart(new FileDataBodyPart("file-data", new File("test.txt")));
            return Response.ok(multiPart).build();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(TestResource.class)
                .register(MultiPartFeature.class);
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    @Test
    public void testIt() throws Exception {
        final Response res = target("test")
                .request().get();
        FormDataMultiPart multiPart = res.readEntity(FormDataMultiPart.class);
        FormDataBodyPart jsonPart = multiPart.getField("json-data");
        FormDataBodyPart filePart = multiPart.getField("file-data");

        Model jsonData = jsonPart.getValueAs(Model.class);
        InputStream file = filePart.getValueAs(InputStream.class);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(file));
        String fileData = fileReader.readLine();

        file.close();
        fileReader.close();

        System.out.println(jsonData.getValue());
        System.out.println(fileData);

        assertThat(jsonData.getValue()).isEqualTo("Test Value");
        assertThat(fileData).isEqualTo("Some Test Data in File");
    }
}