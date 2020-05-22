DetachedCriteria criteria1 = DetachedCriteria.forClass(Business.class)
.setProjection(Property.forName("area"));

DetachedCriteria criteria2 = DetachedCriteria.forClass(Business.class)
.setProjection(Property.forName("area2"));

Criteria criteriaArea = fullTextSession.createCriteria(Area.class)
.add(Restrictions.or(
  Property.forName("areaId").in(criteria1),
  Property.forName("areaId").in(criteria2)
);