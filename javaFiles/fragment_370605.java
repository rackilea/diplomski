@Override
  public void run(
      final BackendConfiguration configuration,
      final Environment environment) {
    Injector injector =
        Guice.createInjector(
            new AbstractModule() {
              @Override
              protected void configure() {

                bindConstant().annotatedWith(Names.named("{someName}"))
                    .to(configuration.getUploadFileLocation());
              }
            });