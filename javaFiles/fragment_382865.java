class MyConfigurationModule extends AbstractModule {
  @Override
  protected void configure() {
    requestInjection(this);
  }

  @Inject
  void configureDbi(DBI dbi) {
    // Do whatever configuration.
  }  
}