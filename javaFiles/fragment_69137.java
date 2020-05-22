@Before
public void createInjector() {
  this.injector = Guice.createInjector(
      new ZAModule(),
      new FakeBModule(),
      new CModule(),
      new DModule());
}