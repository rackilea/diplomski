Criteria criteria = getSession().createCriteria(Sending.class);
DetachedCriteria dc = DetachedCriteria.forClass(Sending.class, "adpw");
dc.add(Restrictions.eqProperty("adpw.place", "adp.place"));
dc.setProjection(Projections.max("id"));
criteria.add(Property.forName("id").eq(dc));
criteria.setMaxResults(count).setFirstResult(start);
return criteria.list();