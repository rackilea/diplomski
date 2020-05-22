final Injector inj = Guice.createInjector(new MyCamelModule());
    Main main = new Main() {
      @Override
      protected Injector getInjectorFromContext() throws Exception {
        return inj;
      }
    };
    main.enableHangupSupport();
    main.run(args);