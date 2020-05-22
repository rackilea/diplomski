// Later on be sure to bind(Foo.class).toProvider(FooProvider.class);
final class FooProvider implements Provider<Foo> {
  private final Provider<Foo> unboundFooProvider;

  private Foo currentInstance;

  @Inject FooProvider(@Unbound Provider<Foo> unboundFooProvider) {
    this.unboundFooProvider = unboundFooProvider;
  }

  @Override public Foo get() {
    if (currentInstance != null) {
      currentInstance.unbind();
    }
    currentInstance = unboundFooProvider.get();
    currentInstance.bind();
    return currentInstance;
  }
}