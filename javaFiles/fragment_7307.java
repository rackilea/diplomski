import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.ModelProcessor;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceModel;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertyResolver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Stack Overflow http://stackoverflow.com/q/34943650/2587435
 * 
 * Run it like any other JUnit test. Required dependencies are as follows:
 * 
 * <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 * </dependency>
 * <dependency>
 *     <groupId>org.glassfish.jersey.ext</groupId>
 *     <artifactId>jersey-spring3</artifactId>
 *     <version>2.22.1</version>
 *     <scope>test</scope>
 * </dependency>
 * <dependency>
 *     <groupId>commons-logging</groupId>
 *     <artifactId>commons-logging</artifactId>
 *     <version>1.1</version>
 *     <scope>test</scope>
 * </dependency>
 * 
 * @author Paul Samsotha
 */
public class SpringPathResolverTest extends JerseyTest {

    @Path("${resource}")
    public static class TestResource {

        @GET
        public String get() {
            return "Resource Success!";
        }

        @GET
        @Path("${sub.resource}")
        public String getSubMethod() {
            return "Sub-Resource Success!";
        }

        @Path("${sub.resource.locator}")
        public SubResourceLocator getSubResourceLocator() {
            return new SubResourceLocator();
        }

        public static class SubResourceLocator {

            @GET
            public String get() {
                return "Sub-Resource-Locator Success!";
            }
        }
    }

    @Configuration
    @PropertySource("classpath:/app.properties")
    public static class SpringConfig {
    }

    public static class PropertyPlaceholderPathResolvingModelProcessor
            implements ModelProcessor {

        @Autowired
        private PropertyResolver propertyResolver;

        @Override
        public ResourceModel processResourceModel(ResourceModel resourceModel,
                javax.ws.rs.core.Configuration configuration) {
            return processResourceModel(resourceModel);
        }

        @Override
        public ResourceModel processSubResource(ResourceModel subResourceModel,
                javax.ws.rs.core.Configuration configuration) {
            return subResourceModel;
        }

        private ResourceModel processResourceModel(ResourceModel resourceModel) {
            ResourceModel.Builder newResourceModelBuilder = new ResourceModel.Builder(false);
            for (final Resource resource : resourceModel.getResources()) {
                final Resource.Builder resourceBuilder = Resource.builder(resource);
                String resolvedResourcePath = processPropertyPlaceholder(resource);
                resourceBuilder.path(resolvedResourcePath);

                // handle child resources
                for (Resource childResource : resource.getChildResources()) {
                    String resolvedChildPath = processPropertyPlaceholder(childResource);
                    final Resource.Builder childResourceBuilder = Resource.builder(childResource);
                    childResourceBuilder.path(resolvedChildPath);
                    resourceBuilder.addChildResource(childResourceBuilder.build());
                }
                newResourceModelBuilder.addResource(resourceBuilder.build());
            }
            return newResourceModelBuilder.build();
        }

        private String processPropertyPlaceholder(Resource resource) {
            String ogPath = resource.getPath();
            return propertyResolver.resolvePlaceholders(ogPath);
        }
    }

    @Override
    public ResourceConfig configure() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return new ResourceConfig(TestResource.class)
                .property("contextConfig", ctx)
                .register(PropertyPlaceholderPathResolvingModelProcessor.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void pathPlaceholderShouldBeResolved() {
        Response response = target("resource").request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is(equalTo("Resource Success!")));
        response.close();

        response = target("resource/sub-resource").request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is(equalTo("Sub-Resource Success!")));
        response.close();

        response = target("resource/sub-resource-locator").request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is(equalTo("Sub-Resource-Locator Success!")));
        response.close();
    }
}