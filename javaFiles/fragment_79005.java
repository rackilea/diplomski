import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Stack Overflow question http://stackoverflow.com/q/36859669/2587435
 * 
 * Run this like any other JUnit test. One one required test dependency:
 * 
 * <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *     <version>${jersey2.version}</version>
 * </dependency>
 *
 * @author Paul Samsotha
 */
public class InterceptionTest extends JerseyTest {

    public static interface HeaderProvider {
        String getXCustomHeader();
    }

    public static class HeaderProviderImpl implements HeaderProvider {
        @Context
        private HttpHeaders headers;

        @Override
        public String getXCustomHeader() {
            return headers.getHeaderString("X-Custom-Header");
        }
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Intercept {
    }

    public static class MyMethodInterceptor implements MethodInterceptor {

        @Inject
        private HeaderProvider provider;

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return provider.getClass().getName() + ":" + provider.getXCustomHeader();
        }

    }

    public static class InterceptionHandler implements InterceptionService {

        private final List<MethodInterceptor> interceptors;

        @Inject
        public InterceptionHandler(ServiceLocator locator) {
            final MethodInterceptor interceptor = new MyMethodInterceptor();
            locator.inject(interceptor);
            interceptors = Collections.singletonList(interceptor);
        }

        @Override
        public Filter getDescriptorFilter() {
            return BuilderHelper.allFilter();
        }

        @Override
        public List<MethodInterceptor> getMethodInterceptors(Method method) {
            if (method.isAnnotationPresent(Intercept.class)) {
                return interceptors;
            }
            return null;
        }

        @Override
        public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> c) {
            return null;
        }
    }

    public static class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(InterceptionHandler.class)
                    .to(InterceptionService.class)
                    .in(Singleton.class);
            bind(HeaderProviderImpl.class)
                    .to(HeaderProvider.class)
                    .proxy(true)
                    .proxyForSameScope(false)
                    .in(RequestScoped.class);
        }
    }

    @Path("intercept")
    public static class TestResource {

        @GET
        @Intercept
        public String get() {
            return null;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(new Binder())
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));          
    }

    @Test
    public void shouldReturnHeaderAndProxyClass() {
        Response response = target("intercept").request()
                .header("X-Custom-Header", "Value1")
                .get();
        assertThat(response.getStatus(), is(200));
        String entity = response.readEntity(String.class);
        response.close();
        assertThat(entity, containsString("Value1"));
        assertThat(entity, containsString("Proxy"));

        // Change header to make sure we aren't getting the same HttpHeaders instance
        response = target("intercept").request()
                .header("X-Custom-Header", "Value2")
                .get();
        assertThat(response.getStatus(), is(200));
        entity = response.readEntity(String.class);
        response.close();
        assertThat(entity, containsString("Value2"));
        assertThat(entity, containsString("Proxy"));
    }
}