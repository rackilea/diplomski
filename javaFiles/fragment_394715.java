@Singleton
public class FeatureClassFactory {
  private final Provider<FeatureClass> provider;
  private FeatureClass instance;

  @Inject
  FeatureClassFactory(Provider<FeatureClass> provider) {
    this.provider = provider;
  }

  public synchronized FeatureClass get() {
    if (instance == null) {
      instance = provider.get();
    }
    return instance;
  }
}