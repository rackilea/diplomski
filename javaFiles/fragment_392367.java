public class MyGuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
            new ServletModule() {
                @Override
                protected void configureServlets() {
                    install(new MyGuiceModule());

                    serve("*").with(Test.class);
                    bind(Test.class).in(Singleton.class);
                }
            }
        );
    }
}