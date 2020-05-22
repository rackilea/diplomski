public class OrderSet extends ForwardingSet<Order> {
  private final ImmutableSet<Order> orders;
  public class OrderSet (Set<Order> orders) {
    this.orders = ImmutableSet.copyOf(orders);
  }
  protected ImmutableSet<Order> delegate() { return orders; }
}