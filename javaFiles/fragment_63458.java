public class MyModule extends AbstractModule {

  ...

  @Provides
  @Singleton
  public MetricRegistry provideRegistry( Environment environment ) {
    return environment.metrics();
  }
}