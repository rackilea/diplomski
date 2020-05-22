public <T> T inject(Class<T> clazz) {
    MyAppModule module = new MyAppModule();
    Injector injector = Guice.createInjector(module);

    return injector.getInstance(clazz);
}