@Module
public class PetshopModule {

  @Provides
  Language provideLanguage() {
    return SystemApp.getSystemLanguage();
  }
}