static interface A<T> {}
static abstract class B<T> implements A<T> {}
static class C<T> extends B<T> {}

static class MyModule extends AbstractModule {
  @Override protected void configure() {
    bind(Key.get(A.class, Names.named("id"))).toProvider(new MyProvider());
  }
}

static class MyProvider implements Provider<A<?>> {
  @Inject Injector injector;
  @Override public A<?> get() {
    return (A<?>) injector.getInstance(C.class);
  }
}

public static void main(String[] args) {
  Injector injector = Guice.createInjector(new MyModule());
  A<?> a = injector.getInstance(Key.get(A.class, Names.named("id")));

  System.out.println(a instanceof A);
  System.out.println(a instanceof B);
  System.out.println(a instanceof C);
}