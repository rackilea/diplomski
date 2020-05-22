public class MyApplication extends ResourceConfig {
    public MyApplication() {
      Genson genson = new GensonBuilder()
              .withBundle(new JAXBBundle())
              .useConstructorWithArguments(true)
              .setSkipNull(true)
              .create();

      register(new GensonJaxRSFeature().use(genson));
    }
}