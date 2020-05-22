List<Order> orders = findOrderByUserId(userName);
for (Order order: orders) {
    if (order.anyOutstanding()) {
        order.complete();    // which internally update the state
    } else if (order.expired) {
        session.delete(order);
    }
}

session.flush();   // or you may simply leave it to flush automatically before txn commit