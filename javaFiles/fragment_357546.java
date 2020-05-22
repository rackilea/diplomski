import java.io.Closeable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.CloseableService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InjectCloseableTest extends JerseyTest {

    public static final String CONNECTION_MSG = "Connection";

    public static class ConnectionProvider implements Closeable {
        private static final Logger LOGGER
                = Logger.getLogger(ConnectionProvider.class.getName());

        public String getConnection() {
            return CONNECTION_MSG;
        }

        @Override
        public void close() {
            LOGGER.info("---- Closing Connection ----");
        }  
    }

    @Path("connection")
    public static class ConnectionResource {

        @Inject
        ConnectionProvider connectionProvider;

        @GET
        public String get() {
            return connectionProvider.getConnection();
        }
    }

    public static class ConnectionProviderFactory implements Factory<ConnectionProvider> {

        @Inject
        CloseableService closeableService;

        @Override
        public ConnectionProvider provide() {
            ConnectionProvider provider = new ConnectionProvider();
            closeableService.add(provider);
            return provider;
        }

        @Override
        public void dispose(ConnectionProvider t) {} 
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(ConnectionResource.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true))
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bindFactory(ConnectionProviderFactory.class)
                                .to(ConnectionProvider.class)
                                .in(RequestScoped.class);
                    }
                });
    }

    @Test
    public void doit() {
        Response response = target("connection").request().get();
        assertEquals(200, response.getStatus());
        assertEquals(CONNECTION_MSG, response.readEntity(String.class));
        response.close();
    }
}