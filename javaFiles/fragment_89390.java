public class DependencyInjectionTest {

    private final ServiceLocatorFactory locatorFactory
            = ServiceLocatorFactory.getInstance();
    private ServiceLocator serviceLocator;

    private final static String BASE_URI = "http://localhost:8888/";
    private final static String OK = "OK";
    private HttpServer server;
    private ExecutorService backgroundService;

    public class EntityManagerProvider extends AbstractBinder
            implements Factory<EntityManager> {

        private final EntityManagerFactory emf;

        public EntityManagerProvider() {
            emf = Persistence.createEntityManagerFactory("derbypu");
        }

        @Override
        protected void configure() {
            bindFactory(this).to(EntityManager.class);
            System.out.println("EntityManager binding done");
        }

        @Override
        public EntityManager provide() {
            EntityManager em = emf.createEntityManager();
            System.out.println("New EntityManager created");
            return em;
        }

        @Override
        public void dispose(EntityManager em) {
            em.close();
        }
    }

    public class BackgroundTask implements Callable<String> {

        @Inject
        EntityManager em;

        @Override
        public String call() throws Exception {
            System.out.println("Background task started");
            Assert.assertNotNull(em);   // will throw exception

            System.out.println("EntityManager is not null");
            return OK;
        }
    }

    public class ServiceLocatorFeature implements Feature {

        @Override
        public boolean configure(FeatureContext context) {
            ServiceLocator jerseyLocator
                    = org.glassfish.jersey.ServiceLocatorProvider
                            .getServiceLocator(context);

            System.out.println("ServiceLocators are the same: "
                    + (jerseyLocator == serviceLocator));

            return true;
        }
    }

    @Path("/test")
    public static class JerseyResource {

        @Inject
        EntityManager em;

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public Response doGet() {
            System.out.println("GET request received");
            Assert.assertNotNull(em);

            System.out.println("EntityManager is not null");
            return Response.ok()
                    .entity(OK)
                    .build();
        }
    }

    @Before
    public void setUp() {
        serviceLocator = locatorFactory.create("TestLocator");
        ServiceLocatorUtilities.bind(serviceLocator, new EntityManagerProvider());

        System.out.println("Setting up");
        ResourceConfig config = new ResourceConfig();
        config.register(new ServiceLocatorFeature());
        //config.register(new EntityManagerProvider());
        config.register(JerseyResource.class);
        // can't find a better way to register the resource
        //config.registerInstances(JerseyResource.class);   

        server = GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI),
                config, serviceLocator
        );

        backgroundService = Executors.newSingleThreadScheduledExecutor();
    }

    @After
    public void tearDown() {
        System.out.println("Shutting down");
        server.shutdownNow();
        backgroundService.shutdownNow();
    }

    @Test
    public void testScheduledBackgroundTask() throws Exception {
        Assert.assertTrue(server.isStarted());

        BackgroundTask task = new BackgroundTask();
        serviceLocator.inject(task);
        Future<String> f = backgroundService.submit(task);
        System.out.println("Background task submitted");

        try {
            Assert.assertEquals(OK, f.get());   // forces Exception
        } catch (ExecutionException | InterruptedException ex) {
            System.out.println("Caught exception " + ex.getMessage());
            ex.printStackTrace();

            Assert.fail();
        }
    }

    @Test
    public void testBackgroundTask() throws Exception {
        Assert.assertTrue(server.isStarted());

        BackgroundTask task = new BackgroundTask();
        serviceLocator.inject(task);
        System.out.println("Background task instantiated");

        Assert.assertEquals(OK, task.call());
    }

    @Test
    public void testResource() {
        Assert.assertTrue(server.isStarted());

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI);

        Response r = target.path("test")
                .request()
                .get();
        Assert.assertEquals(200, r.getStatus());
        Assert.assertEquals(OK, r.readEntity(String.class));
    }
}