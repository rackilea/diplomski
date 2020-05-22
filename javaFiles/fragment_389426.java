List<Order> orders = getOrders();
 List<LineItem> lineItems = new ArrayList<>();

 for (final Order order : orders) {
     lineItems.addAll(order.getItems());
 }