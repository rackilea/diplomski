public enum InjectorProvider {
  INSTANCE;
  private Injector injector;
  public Injector getInjector() {
    return injector;
  }
  public void setInjector(Injector injector) {
    this.injector = injector;
  }      
}