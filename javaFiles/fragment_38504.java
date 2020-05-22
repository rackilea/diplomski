@Configuration
public static class RepositoryConfig extends
        RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config) {
        config.exposeIdsFor(Class1.class, Class2.class);
    }
}