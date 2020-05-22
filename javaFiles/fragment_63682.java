class ManualManagerFactory {
  // ShiftFactory is stateless, so you don't have to inject a Provider,
  // but if it were stateful like a Database or Cache this would matter more.
  @Inject Provider<ShiftFactory> shiftFactoryProvider;

  @Override public Manager createManager(int managerId) {
    return new Manager(managerId, shiftFactoryProvider.get());
  }
}