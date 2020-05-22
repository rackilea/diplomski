DetachedCriteria kSubquery = DetachedCriteria.forClass(TableJPE.class,"j2");
kSubQuery = kSubQuery.createAlias("k","k2");
kSubQuery.setProjection(Projections.max("k2.date"));
kSubQuery = kSubQuery.add(Restrictions.eqProperty("j.id", "j2.id"));
rootCriteria.add(Restrictions.disjunction()
     .add(Subqueries.propertyEq("k.date",kSubQuery))
     .add(Restrictions.isNull("k.date")));