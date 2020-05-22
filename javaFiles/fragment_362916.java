Criteria crit = session.createCriteria(A.class, "a");

DetachedCriteria cCount = DetachedCriteria.forClass(A.class, "a2");

cCount.createAlias("a2.elements", "elements2");
cCount.add(Restrictions.eqProperty("a2.id", "a.id");
cCount.setProjection(Projections.countDistinct("elements2.object.id");

crit.add(Subqueries.lt(1L, areaCount);

return (List<A>) crit.list();