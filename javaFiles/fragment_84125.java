class TestProvider implements Provider<Map<String, Map<String, String>>> {
  @Override public Map<String, Map<String, String>> get() {
    // If you had Guava, you could just call "return Maps.newHashMap();".
    // On Java 7, you can use "return new HashMap<>();".
    return new HashMap<String, Map<String, String>>();
  }
}

class TestModule extends AbstractModule {
  @Override protected void configure() {
    bind(new TypeLiteral<Map<String, Map<String, String>>>() {})
        .toProvider(TestProvider.class);
    // or
    bind(new TypeLiteral<HashMap<String, HashMap<String, String>>>() {})
        .toProvider(HashMapTestProvider.class);
  }
}