public class MyAppModule extends PrivateModule {
  private static final Injector blueInjector = Guice.createInjector(new BlueModule());
  private static final Injector redInjector = Guice.createInjector(new RedModule());

  @Override
  protected void configure()
  {
    bind(ExecutorService.class).toInstance(Executors.newSingleThreadExecutor());
    bind(MyService.class).to(MyServiceImpl.class);
    bind(MyOtherService.class).to(MyOtherServiceImpl.class);
    expose(MyService.class);
    expose(MyOtherService.class);
  }

  @Provides
  RedService getRedService()
  {
    return redInjector.getInstance(RedService.class);
  }

  @Provides
  BlueService getBlueService()
  {
    return blueInjector.getInstance(BlueService.class);
  }
}