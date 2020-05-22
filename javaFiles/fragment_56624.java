public class YourApplicationClass implements HasActivityInjector {

  private AppComponent appComponent;
  @Override
  public void onCreate() {
      super.onCreate();

      appComponent = DaggerAppComponent.builder()
              .application(this)
              .build();

      appComponent.inject(this);
  }

  public AppComponent getAppComponent() {
      return appComponent;
  }
}