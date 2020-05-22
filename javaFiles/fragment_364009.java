Criteria crit = session.createCriteria(Notification.class, "main");

DetachedCriteria notificationSubQuery = DetachedCriteria.forClass(Notification.class, "sub");
notificationSubQuery.setProjection(Projections.max("date"));
notificationSubQuery.add(Restrictions.eqProperty("sub.serviceId", "main.serviceId"));

crit.add(Subqueries.propertyIn("date", notificationSubQuery));
crit.addOrder(Order.desc("date"));