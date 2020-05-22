class OrderApplicationService {
  public void cancelOrder(String orderId) {
    Order order = orderRepository.getOrder(orderId);
    order.setOrderStatus(CANCELLED);
    order.setOpenQuantity(0);
    orderRepository.update(order);
  }
}