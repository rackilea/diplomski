public class JaxRsApplication extends Application {

    private Set<Object> singletons = new HashSet<>();

    public JaxRsApplication(@Context ServletContext servletContext) {
        Assert.assertNotNull(servletContext);
        singletons.add( new UserDatabaseResource(servletContext) );
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}