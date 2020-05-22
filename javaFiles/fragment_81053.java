public class MyModule extends AbstractModule {
  private static final Foo foo;

  public MyModule(Foo foo) {
    this.foo = foo;
  }

  @Override
  public void configure() {
    bind(Bar.class).toProvider(new BarProvider(foo, getProvider(Baz.class));
  }

  static BarProvider implements Provider<Bar> {
    private final Foo foo;
    private final Provider<Baz> bazProvider;

    BarProvider(Foo foo, Provider<Baz> bazProvider) {
      this.foo = foo;
      this.bazProvider = bazProvider;
    }

    @Override public Bar get() {
      return foo.getBar(bazProvider.get());
    }
  }
}