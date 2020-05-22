public class ImplementationGetter {
  @Inject
  private IterableProvider<MyInterface> interfaceProvider;

  public MyInterface getImplementation(final String type_) {
    return interfaceProvider.named(type_).get();
  }
}