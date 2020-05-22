public class MyAppModule extends PrivateModule {
  install(new PrivateModule() {
    install(new RedModule());
    expose(RedService.class);
  });
  install(new PrivateModule() { 
    install(new BlueModule());
    expose(BlueService.class);
  });

  final Module myAppExecutorService = new PrivateModule() {
    bind(ExecutorService.class).toInstance(Executors.newSingleThreadExecutor());  
    expose(ExecutorService.class);
  };
  install(new PrivateModule() {
    install(myAppExecutorService);
    bind(AwesomeService.class).to(AwesomeServiceImpl.class);
    expose(AwesomeService.class);
  });  
  expose(AwesomeService.class);
}