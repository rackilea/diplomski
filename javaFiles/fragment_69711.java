public class MyAppModule extends PrivateModule {
  install(new RedModule());
  install(new BlueModule());
  bind(ExecutorService.class).toInstance(Executors.newSingleThreadExecutor());
  bind(AwesomeService.class).to(AwesomeServiceImpl.class);
  expose(AwesomeService.class);
}