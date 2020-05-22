class Manager {
  private final ShiftFactory shiftFactory;  // set in constructor
  private final int managerId;              // set in constructor

  @Inject Manager(ShiftFactory shiftFactory, @Assisted int managerId) {
    this.shiftFactory = shiftFactory;
    this.managerId = managerId;
  }

  // ...
}

// and in your AbstractModule's configure method:
new FactoryModuleBuilder().build(ManagerFactory.class);