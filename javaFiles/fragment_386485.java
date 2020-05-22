@Module
public class AppModule {
  // ...
  @Provides
  public SharedPreferences providePreferences(){
    return new AppSharedPreferences(appContext, prefFile);
  }
}