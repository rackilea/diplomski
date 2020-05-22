class MyModule extends AbstractModule {

  private static class MyProvider implements Provider<SomeClass> {
    private final OtherStuff otherStuff;

    @Inject
    MyProvider(OtherStuff otherStuff) {
      // Inject constructor params if your @Provides method took arguments
      this.otherStuff = otherStuff;
    }

    public SomeClass get() {
      return new SomeClass(otherStuff);
    }
  }

  protected void configure() {
    bind(SomeClass.class).toProvider(MyProvider.class).asEagerSingleton();
  }
}