class Visitor {
  @Inject Injector injector;

  void enter(final Node node) {
    Service service = injector.createChildInjector(new AbstractModule() {
      @Override public void configure() {
        bind(Node.class).toInstance(node);
        // Anything that does require a Node should be bound here, because
        // you can't define it in the parent due to the unsatisfied binding.
        bind(SomeInterface.class).to(SomeClassThatRequiresNode.class);
      }
    }).getInstance(Service.class);

    service.doComplexDomainLogic(/* ... */)
  }
}