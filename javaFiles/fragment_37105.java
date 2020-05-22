List<Order> orders = findOrderByUserId(userName);
for (Order order: orders) {
    if (order outstanding quantity is 0) {
        dbConn.addBatch("update ORDER set STATE='C' where ID=:id", order.id);
    } else if (order is after expriation time) {
        dbConn.addBatch("delete ORDER where ID=:id", order.id);
    }
}
dbConn.executeBatch();