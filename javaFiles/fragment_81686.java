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
import java.util.Map;
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
import org.glassfish.jersey.internal.util.PropertiesHelper;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.CloseableService;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WebXmlCustomDaoTest extends JerseyTest {

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
    public static @interface CustomContext {
    }

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
            for (Class type : daoClasses.getDaoClasses()) {
                if (requiredType == type) {
                    IDao dao = locator.getService(IDao.class, type.getCanonicalName());
                    addToCloseableService(dao);
                    return type.cast(dao);
                }
            }
            return null;
        }

        private void addToCloseableService(final IDao idao) {
            closeableService.add(new Closeable() {
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

        public IDaoProviders(Class<? extends IDao>... daoClasses) {
            this.daoClasses = new ArrayList<>(Arrays.asList(daoClasses));
        }

        public List<Class<? extends IDao>> getDaoClasses() {
            return daoClasses;
        }
    }

    public static class DaoFeature implements Feature {

        public static final String DAO_IMPLEMENTATIONS = "dao.implementations";

        @Override
        public boolean configure(FeatureContext context) {
            Map<String, Object> props = context.getConfiguration().getProperties();
            String initParam = getValue(props, DAO_IMPLEMENTATIONS, String.class);
            context.register(new Binder(getFromStringParam(initParam)));
            return true;
        }

        private List<Class<? extends IDao>> getFromStringParam(String initParam) {
            String[] daoClassNames = initParam.split(",");
            List<Class<? extends IDao>> daoClasses = new ArrayList<>();
            for (int i = 0; i < daoClassNames.length; i++) {
                try {
                    String classname = daoClassNames[i].trim();
                    Class<?> cls = Class.forName(daoClassNames[i].trim());
                    if (IDao.class.isAssignableFrom(cls)) {
                        Class<? extends IDao> c = (Class<? extends IDao>)cls;
                        daoClasses.add(c);
                    }
                } catch (ClassNotFoundException ex) {
                    // noop - ignore non IDao classes.
                    System.out.println(ex.getMessage());
                }
            }
            return daoClasses;
        }

        public static <T> T getValue(Map<String, ?> properties, String key, Class<T> type) {
            return PropertiesHelper.getValue(properties, key, type, null);
        }

        private class Binder extends AbstractBinder {

            List<Class<? extends IDao>> daoClasses;

            public Binder(List<Class<? extends IDao>> daoClasses) {
                this.daoClasses = daoClasses;
            }

            @Override
            protected void configure() {
                bind(CustomContextResolver.class)
                        .to(new TypeLiteral<InjectionResolver<CustomContext>>() {
                        })
                        .in(Singleton.class);
                bindFactory(DummyEntityManagerFactory.class)
                        .to(DummyEntityManager.class)
                        .in(RequestScoped.class);

                for (Class<? extends IDao> daoClass : daoClasses) {
                    bind(daoClass).to(IDao.class)
                            .named(daoClass.getCanonicalName()).in(RequestScoped.class);
                }

                Class<? extends IDao>[] array = daoClasses.toArray(new Class[]{});
                IDaoProviders daoProviders = new IDaoProviders(array);
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
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    /**
     * 
     * This method is to configure a web deployment using a "web.xml".
     * 
     * The "dao.implementations" is a property from the `DaoFeature`
     * The user should list the `IDao` implementation classes separated
     * by a comma.
     *
     * The `DaoFeature` is register with the Jersey init-param
     * `jersey.config.server.provider.classnames`
     * 
     * The class names I listed use a `$` only because they are inner classes.
     * Normally you would not need that.
     * 
     * See http://stackoverflow.com/a/7007859/2587435
     */
    @Override
    protected DeploymentContext configureDeployment() {
        return ServletDeploymentContext
                .forServlet(ServletContainer.class)
                .initParam("jersey.config.server.provider.packages", 
                        this.getClass().getPackage().getName())
                .initParam("jersey.config.server.provider.classnames", 
                        "com.stackoverflow.dao.WebXmlCustomDaoTest$DaoFeature")
                .initParam("dao.implementations",
                        "com.stackoverflow.dao.WebXmlCustomDaoTest$DaoImplOne,"
                        + "com.stackoverflow.dao.WebXmlCustomDaoTest$DaoImplTwo")
                .build();
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