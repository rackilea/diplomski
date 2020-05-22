// Other imports excluded for brevity
import static io.github.restdocsext.jersey.JerseyRestDocumentation.document;
import static io.github.restdocsext.jersey.JerseyRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.removeHeaders;

public class SimpleDocumentation extends JerseyTest {

    @Rule
    public JUnitRestDocumentation documentation 
            = new JUnitRestDocumentation("target/generated-snippets");

    @Path("test")
    public static class TestResource {
        @GET
        public String getSimple() {
            return "SimpleTesting";
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class);
    }

    @Test
    public void getSimple() {
        final Response response = target("test")
                .register(documentationConfiguration(this.documentation)) 
                .register(document("get-simple", 
                        preprocessRequest(removeHeaders("User-Agent")))) 
                .request()
                .get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("SimpleTesting"));
    }
}