public class ProductionModule implements Module {
    public void configure(Binder binder) {
        binder.bind(InterfaceA.class).to(ConcreteA.class);
        binder.bind(InterfaceB.class).to(ConcreteB.class);
        binder.bind(InterfaceC.class).to(ConcreteC.class);
    }
}
public class TestModule implements Module {
    public void configure(Binder binder) {
        binder.bind(InterfaceC.class).to(MockC.class);
    }
}
Guice.createInjector(Modules.override(new ProductionModule()).with(new TestModule()));