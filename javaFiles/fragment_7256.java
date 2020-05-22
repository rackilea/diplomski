import java.io.IOException;
import java.security.Principal;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomInjectTestTake2 extends JerseyTest {

    private static final String PRINCIPAL_NAME = "peeskillet";
    private static final String MESSAGE = "Hello World";
    private static final String RESPONSE = PRINCIPAL_NAME + ":" + MESSAGE;

    public static class CustomModel {

        @Context
        public SecurityContext securityContext;
        public RequestBody body;
    }

    public static class RequestBody {

        public String message;
    }

    @PreMatching
    public static class SecurityContextFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            requestContext.setSecurityContext(new SecurityContext(){
                public Principal getUserPrincipal() {
                    return new Principal() { 
                        public String getName() { return PRINCIPAL_NAME; }
                    };
                }
                public boolean isUserInRole(String role) { return false; }
                public boolean isSecure() { return true;}
                public String getAuthenticationScheme() { return null; }
            });   
        }  
    }

    @Path("test")
    public static class TestResource {
        @POST
        @Produces(MediaType.TEXT_PLAIN)
        @Consumes(MediaType.APPLICATION_JSON)
        public String post(@BeanParam CustomModel model) {
            return model.securityContext.getUserPrincipal().getName() 
                    + ":"  + model.body.message;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(SecurityContextFilter.class);
    }

    @Test
    public void should_return_name_with_body() {
        RequestBody body = new RequestBody();
        body.message = "Hello World";
        Response response = target("test").request()
                .post(Entity.json(body));
        assertEquals(200, response.getStatus());
        String responseBody = response.readEntity(String.class);
        assertEquals(RESPONSE, responseBody);
        System.out.println(responseBody);
    }
}