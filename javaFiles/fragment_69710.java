public class MyAppModule extends PrivateModule {
  install(new RedModule());
  install(new BlueModule());
  bind(AwesomeService.class).to(AwesomeServiceImpl.class);
  expose(AwesomeService.class);
}