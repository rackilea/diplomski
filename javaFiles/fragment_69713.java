public class MyAppModule extends PrivateModule {
  install(new PrivateModule() {
    install(new RedModule());
    expose(RedService.class);
  });
  install(new PrivateModule() { 
    install(new BlueModule());
    expose(BlueService.class);
  });
  bind(ExecutorService.class).toInstance(Executors.newSingleThreadExecutor());
  bind(AwesomeService.class).to(AwesomeServiceImpl.class);
  expose(AwesomeService.class);
}