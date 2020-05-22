public class YourModule extends AbstractModule {
  @Override public void configure() {
    install(new FactoryModuleBuilder().build(B.Factory.class));
    install(new FactoryModuleBuilder().build(C.Factory.class));
  }
}