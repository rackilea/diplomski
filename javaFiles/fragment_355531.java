long fetchTime = ....;  /* fetch time in hours */
String queryString = "FROM Orders o WHERE o.orderMade >= :orderTime";
Query query = session.createQuery(queryString);
Timestamp orderTime = new Timestamp(System.currentTimeMillis() - fetchTime * 60L * 60L * 1000L);
query.setTimestamp("orderTime", orderTime);
@SuppressWarnings("unchecked")
List<Orders> orders = query.list();