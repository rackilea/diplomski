@Before
public void createInjector() {
  this.injector = Guice.createInjector(
      Modules.override(new YourZABCDModule()).with(new AbstractModule() {
        @Override public void configure() {
          bind(B.class).to(FakeB.class);
        }
      }));
}