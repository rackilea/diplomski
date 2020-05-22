public class GuiceConfiguration extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                install(new RestServicesModule());    


                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);

                serve("*").with(GuiceContainer.class, ImmutableMap.of("com.sun.jersey.config.feature.Trace",
                                "true"));
            }
        });
    }
}