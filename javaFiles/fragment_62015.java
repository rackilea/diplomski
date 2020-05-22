import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.restdocs.RestDocumentation;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

/**
 * Stack Overflow http://stackoverflow.com/q/35068860/2587435
 * 
 * Run this like any other JUnit test. The required dependencies are listed below. You will need
 * to add the Spring Snapshot repository, also listed below.
 * 
 * Running the test should produces the following snippets in target/generated-snippets/example-put:
 * 
 * - curl-request.adoc
 * - http-request.adoc
 * - http-response.adoc
 * - path-parameters.adoc
 * - request-fields.adoc
 * - response-fields.adoc
 * 
 * <dependencies>
 *   <dependency>
 *     <groupId>org.springframework.restdocs</groupId>
 *     <artifactId>spring-restdocs-restassured</artifactId>
 *     <version>1.1.0.BUILD-SNAPSHOT</version>
 *     <scope>test</scope>
 *   </dependency>
 *   <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 *   </dependency>
 *   <dependency>
 *     <groupId>org.glassfish.jersey.media</groupId>
 *     <artifactId>jersey-media-json-jackson</artifactId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 *   </dependency>
 *   <dependency>
 *     <groupId>commons-logging</groupId>
 *     <artifactId>commons-logging</artifactId>
 *     <version>1.2</version>
 *     <scope>test</scope>
 *   </dependency>
 *   <dependency>
 *     <groupId>org.hamcrest</groupId>
 *     <artifactId>hamcrest-all</artifactId>
 *     <version>1.3</version>
 *     <scope>test</scope>
 *   </dependency>
 * </dependencies>
 * 
 * <repositories>
 *   <repository>
 *     <id>spring-snapshots</id>
 *     <name>Spring snapshots</name>
 *     <url>https://repo.spring.io/libs-snapshot</url>
 *     <snapshots>
 *       <enabled>true</enabled>
 *     </snapshots>
 *   </repository>
 * </repositories>
 *
 * @author Paul Samsotha
 */
public class RestAssuredDocs extends JerseyTest {

    @Rule
    public final RestDocumentation restDocumentation 
            = new RestDocumentation("target/generated-snippets");

    public static class TestBean {
        public int id;
        public String message;
        public TestBean (){}
        public TestBean(int id, String message) {
            this.id = id;
            this.message = message;
        }
    }

    @Path("test")
    @Produces("application/json")
    @Consumes("application/json")
    public static class TestResource {

        @PUT
        @Path("{id}")
        public TestBean update(TestBean bean) {
            return bean;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    private final int port = 9998;
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void examplePut() throws Exception {
        TestBean bean = new TestBean(1, "a message");
        given().port(this.port)
                .filter(documentationConfiguration(this.restDocumentation))
                .filter(document("example-put", 
                        requestFields(
                                fieldWithPath("id").description("The id"),
                                fieldWithPath("message").description("The message")
                        ),
                        responseFields(
                                fieldWithPath("id").description("The id"),
                                fieldWithPath("message").description("The message")
                        ),
                        pathParameters(
                                parameterWithName("id").description("The id")
                        )
                ))
                .contentType("application/json")
                .accept("application/json")
                .content(mapper.writeValueAsString(bean))
                .put("/test/{id}", "1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("message", equalTo("a message"));

    }
}