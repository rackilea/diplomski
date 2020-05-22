public static MyClass createMyClassObject(
        Optional<SpecialInterface> customSpecialInterfaceObject) {

    MyClassModule myClassModule = new MyClassModule(customSpecialInterfaceObject);
    Injector injector = Guice.createInjector(myClassModule);
    MyClassFactory instance = injector.getInstance(MyClassFactory.class);
    return instance.createMyClassObject();
}

class MyClassModule extends AbstractModule {
  private final Optional<SpecialInterface> customObject;

  MyClassModule(Optional<SpecialInterface> customObject) {
    this.customObject = customObject;
  }

  @Override public void configure() {
    if (customObject.isPresent()) {
      // Singleton by necessity: Guice doesn't know how to create another one.
      bind(SpecialInterface.class).toInstance(customObject.get());
    } else {
      // Default scoped. Add ".in(Singleton.class)" if necessary.
      bind(SpecialInterface.class).toInstance(DefaultSpecialInterfaceClass.class);
    }
  }
}