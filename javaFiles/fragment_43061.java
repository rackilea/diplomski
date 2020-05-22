public final class MyModule<T extends Parent> extends AbstractModule {
  private final Key<T> key;
  private final Provider<T> provider;

  public MyModule(final Class<T> clazz, final String[] args) {
    this.key = Key.get(clazz); // Or add an annotation if you feel like it
    this.provider = new Provider<T>() {
      @Override public T get() {
        try {
          T instance = clazz.newInstance();
          // etc.
        } catch (ReflectiveOperationException ex) {
          // throw a RuntimeException here
        }
      }
    };
  }

  @Override protected void configure() {
    bind(key).toProvider(provider).in(Singleton.class);
  }
}