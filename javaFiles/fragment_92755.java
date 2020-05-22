String q = "find * fetch subscriptions "
         + "where subscriptions.startDate > :today "
         + "   or subscriptions.endDate < :today "
         + "   or subscriptions.id is null";
Query<Person> query = Ebean.createQuery(Person.class, q);
query.setParameter("today", LocalDate.now());
return query.findList();