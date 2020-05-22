public class RestModule extends ServletModule{

    @Override
    protected void configureServlets() {
        bind(MyServiceClass.class);

        // hook Jersey into Guice Servlet
        bind(GuiceContainer.class);

        // hook Jackson into Jersey as the POJO <-> JSON mapper
        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

        Map<String, String> guiceContainerConfig = new HashMap<String, String>();

        serve("/*").with(GuiceContainer.class, guiceContainerConfig);

        filter("/*").through(CorsFilter.class);
    }
}