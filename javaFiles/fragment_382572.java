public class EnglishLanguage implements Language {

  @Inject
  public EnglishLanguage() {
  }

  @Override
  public String getSalute() {
    return "Hello!";
  }
}

@Module
public class PetshopModule {

  @Provides
  Language provideLanguage(EnglishLanguage language) {
    return language;
  }
}