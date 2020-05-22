// Interface for Order

interface Order {
  void cancel();

  // no setters!!!
}

class OrderImpl extends Order {
  @Override
  void cancel() {
    this.status = CANCELLED;
    this.openQuantity = 0;
  }

  void setId(String orderId) { ... }
  // some other setters
}

class OrderApplicationService {
  public void cancelOrder(String orderId) {
    Order order = orderRepository.getOrder(orderId);
    order.cancel();
    orderRepository.update(order);
  }
}