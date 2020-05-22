public class SomeTest extends JerseyTestNg.ContainerPerClassTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyWebTestContainerFactory();
    }

@Override
    protected Application configure() {
        return new ResourceConfig()
                .packages("com.example.ws")
                .register(GensonCustomResolver.class);
    }

    @Override
    protected DeploymentContext configureDeployment() {
        Application application = configure();

        return ServletDeploymentContext.builder(application)
                .addListener(JerseyGuiceServletContextListener.class)
                .addFilter(GuiceFilter.class, "guiceFilter")
                .addFilter(ServletContainer.class, "jerseyFilter", new HashMap<String, String>(){{
                    put("javax.ws.rs.Application", JerseyConfiguration.class.getCanonicalName());
                }})
                .build();
    }

    @Test
    public void test() {
        Assert.assertEquals(1, 1);
    }
}