import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

public class ContextResolverTest extends JerseyTest {

    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public static class OMContextResolver implements ContextResolver<ObjectMapper> {

        private final ObjectMapper mapper = new ObjectMapper();

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return mapper;
        }
    }

    @Provider
    public static class Filter implements ContainerRequestFilter  {

        @Context
        private Providers providers;

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException { 
            ContextResolver<ObjectMapper> contextResolver 
                    = providers.getContextResolver(ObjectMapper.class, 
                            MediaType.APPLICATION_JSON_TYPE);
            if (contextResolver == null) {
                requestContext.abortWith(
                            Response.serverError().entity("no resolver").build());
            } else {
                ObjectMapper mapper = contextResolver.getContext(null);
                if (mapper == null) {
                    requestContext.abortWith(
                            Response.serverError().entity("no mapper").build());
                    return;
                }
                requestContext.abortWith(
                            Response.ok("resolver found").build());
            }
        }
    }

    @Path("test")
    public static class TestResource {
        @GET
        public String dummyGet() {
            return "Boo";
        }
    }

    @Override
    public Application configure() {
        ResourceConfig config = new ResourceConfig();
        config.register(TestResource.class);
        config.register(OMContextResolver.class);
        config.register(Filter.class);
        return config;
    }

    @Test
    public void contextResolverIsOk() {
        Response response = target("test").request().get();
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("resolver found", response.readEntity(String.class));
        response.close();
    }
}