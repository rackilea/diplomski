@AutoFactory(
    className = "AutoManagerFactory", implementing = {ManagerFactory.class})
class Manager {
  private final ShiftFactory shiftFactory;  // set in constructor
  private final int managerId;              // set in constructor

  @Inject Manager(@Provided ShiftFactory shiftFactory, int managerId) {
    this.shiftFactory = shiftFactory;
    this.managerId = managerId;
  }

  // ...
}