public class Config extends GuiceServletContextListener {

  protected Injector getInjector() {
    return Guice.createInjector(
        new JerseyServletModule() {
          protected void configureServlets() {
            bind(Service.class);
            serve("/services/*").with(GuiceContainer.class);
          }
        });
  }

}