List<Order> orders = findOrderByUserId(userName);
for (Order order: orders) {
    if (order outstanding quantity is 0) {
        q = session.createQuery("update Order set state='C' where id=:id");
        q.setParameter("id", order.id);
        q.executeUpdate();
    } else if (order is after expriation time) {
        q = session.createQuery("delete Order where id=:id");
        q.setParameter("id", order.id);
        q.executeUpdate();
    }
}