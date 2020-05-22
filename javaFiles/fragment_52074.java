public class Application extends io.dropwizard.Application<Configuration>{  

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        environment.jersey().register(ContextResource.class);
        environment.jersey().register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(MyObject.class).to(MyObject.class);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new Application().run("server", "/home/artur/dev/repo/sandbox/src/main/resources/config/test.yaml");
    }
}