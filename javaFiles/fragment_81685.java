import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.CloseableService;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomDaoTest extends JerseyTest {

    public static class DummyEntityManager {
        String findByDaoClass(Class cls) {
            return "Data from " + cls.getSimpleName();
        }
        public void close() { /* noop */ }
    }

    public static abstract class IDao {

        private static final Logger LOG = Logger.getLogger(IDao.class.getName());

        @Inject
        private DummyEntityManager em;

        protected abstract String getData();

        public void close() {
            LOG.log(Level.INFO, "Closing IDAO: {0}", this.getClass().getName());
            em.close();
        }

        protected DummyEntityManager getEntityManager() {
            return em;
        }
    }

    public static class DaoImplOne extends IDao {
        @Override
        public String getData() {
            return getEntityManager().findByDaoClass(this.getClass());
        }
    }

    public static class DaoImplTwo extends IDao {
        @Override
        protected String getData() {
            return getEntityManager().findByDaoClass(this.getClass());
        }   
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
    public static @interface CustomContext{}

    public static class CustomContextResolver 
            implements InjectionResolver<CustomContext> {

        @Inject
        private ServiceLocator locator;

        @Inject
        private IDaoProviders daoClasses;

        @Inject
        private CloseableService closeableService;

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> root) {
            Type requiredType = injectee.getRequiredType();
            for (Class type: daoClasses.getDaoClasses()) {
                if (requiredType == type) {
                    IDao dao = locator.getService(IDao.class, type.getCanonicalName());
                    addToCloseableService(dao);
                    return type.cast(dao);
                }
            }
            return null;
        }

        private void addToCloseableService(final IDao idao) {
            closeableService.add(new Closeable(){
                @Override
                public void close() throws IOException {
                    idao.close();
                }
            });
        }

        @Override
        public boolean isConstructorParameterIndicator() {
            return false;
        }

        @Override
        public boolean isMethodParameterIndicator() {
            return false;
        } 
    }

    public static class DummyEntityManagerFactory 
            extends AbstractContainerRequestValueFactory<DummyEntityManager> {

        @Override
        public DummyEntityManager provide() {
            ContainerRequest request = getContainerRequest();
            // get some condition for EntityManager
            return new DummyEntityManager();
        }
    }

    public static class IDaoProviders {

        private final List<Class<? extends IDao>> daoClasses;

        public IDaoProviders(Class<? extends IDao> ... daoClasses) {
            this.daoClasses = new ArrayList<>(Arrays.asList(daoClasses));
        }

        public List<Class<? extends IDao>> getDaoClasses() {
            return daoClasses;
        }
    }

    public static class DaoFeature implements Feature {

        private final Class<? extends IDao>[] daoClasses;

        public DaoFeature(Class<? extends IDao> ... daoClasses) {
            this.daoClasses = daoClasses;
        }

        @Override
        public boolean configure(FeatureContext context) {
            context.register(new Binder());
            return true;
        } 

        private class Binder extends AbstractBinder {
            @Override
            protected void configure() {
                bind(CustomContextResolver.class)
                        .to(new TypeLiteral<InjectionResolver<CustomContext>>(){})
                        .in(Singleton.class);
                bindFactory(DummyEntityManagerFactory.class)
                        .to(DummyEntityManager.class)
                        .in(RequestScoped.class);

                for (Class<? extends IDao> daoClass: daoClasses) {
                    bind(daoClass).to(IDao.class)
                            .named(daoClass.getCanonicalName()).in(RequestScoped.class);
                }

                IDaoProviders daoProviders = new IDaoProviders(daoClasses);
                bind(daoProviders).to(IDaoProviders.class);
            }    
        }
    }

    @Path("dao")
    public static class DaoResource {

        @CustomContext
        private DaoImplOne daoOne;

        @CustomContext
        private DaoImplTwo daoTwo;

        @GET
        @Path("one")
        public String getOne() {
            return daoOne.getData();
        }

        @GET
        @Path("two")
        public String getTwo() {
            return daoTwo.getData();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(DaoResource.class)
                .register(new DaoFeature(DaoImplOne.class, DaoImplTwo.class));
    }

    @Test
    public void should_return_dao_one_data() {
        Response response = target("dao/one").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("Data from DaoImplOne", response.readEntity(String.class));
        response.close();
    }

    @Test
    public void should_return_dao_two_data() {
        Response response = target("dao/two").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("Data from DaoImplTwo", response.readEntity(String.class));
        response.close();
    }
}