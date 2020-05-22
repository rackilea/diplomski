import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Principal;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomInjectionTest extends JerseyTest {

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface CustomParam {
    }

    public static class CustomModel {

        public String name;
        public RequestBody body;
    }

    public static class RequestBody {

        public String message;
    }

    public static class CustomParamValueFactory
            extends AbstractContainerRequestValueFactory<CustomModel> {

        @Override
        public CustomModel provide() {
            ContainerRequest request = getContainerRequest();
            String name = request.getSecurityContext().getUserPrincipal().getName();
            RequestBody body = request.readEntity(RequestBody.class);
            CustomModel model = new CustomModel();
            model.body = body;
            model.name = name;
            return model;
        }
    }

    public static class CustomValueFactoryProvider extends AbstractValueFactoryProvider {

        @Inject
        public CustomValueFactoryProvider(MultivaluedParameterExtractorProvider multiProvider,
                                          ServiceLocator locator) {
            super(multiProvider, locator, Parameter.Source.UNKNOWN);
        }

        @Override
        protected Factory<?> createValueFactory(Parameter parameter) {
            if (CustomModel.class == parameter.getType()
                    && parameter.isAnnotationPresent(CustomParam.class)) {
                return new CustomParamValueFactory();
            }
            return null;
        }  
    }

    public static class CustomParamInjectionResolver extends ParamInjectionResolver<CustomParam> {

        public CustomParamInjectionResolver() {
            super(CustomValueFactoryProvider.class);
        }
    }

    private static class CustomInjectBinder extends AbstractBinder {

        @Override
        protected void configure() {
            bind(CustomValueFactoryProvider.class)
                    .to(ValueFactoryProvider.class)
                    .in(Singleton.class);
            bind(CustomParamInjectionResolver.class)
                    .to(new TypeLiteral<InjectionResolver<CustomParam>>(){})
                    .in(Singleton.class);
        } 
    }

    private static final String PRINCIPAL_NAME = "peeskillet";

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
        public String post(@CustomParam CustomModel model) {
            return model.name + ":" + model.body.message;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(SecurityContextFilter.class)
                .register(new CustomInjectBinder());
    }

    @Test
    public void should_return_name_with_body() {
        RequestBody body = new RequestBody();
        body.message = "Hello World";
        Response response = target("test").request()
                .post(Entity.json(body));
        assertEquals(200, response.getStatus());
        String responseBody = response.readEntity(String.class);
        assertEquals(PRINCIPAL_NAME + ":" + body.message, responseBody);
        System.out.println(responseBody);
    }
}