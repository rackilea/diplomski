class YourModule extends AbstractModule {
  @Override protected void configure() {
    bind(ChildClass.class).toProvider(ChildClassProvider1.class);
  }

  @Provides SaveAction saveAction(ChildClassProvider2 provider) {
    return new SaveAction(provider.get());
  }
}