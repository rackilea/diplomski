Criteria criteria = session.createCriteria(Address.class, "a");

DetachedCriteria dc = DetachedCriteria.forClass(Person.class, "p");
dc.createAlias("p.addresses", "a2");
dc.add(Restrictions.eq("p.id", personId);
dc.setProjection(Projections.property("a2.id"));

criteria.add(Subqueries.propertyIn("a.id", dc));