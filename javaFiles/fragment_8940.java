Criteria criteria = getCurrentSession().createCriteria(Form.class);             
DetachedCriteria subQuery1 = DetachedCriteria.forClass(Response.class);
subQuery1.add(Restrictions.and(
    Restrictions.eq("id", "firstName").add(
    Restrictions.eq("value", getFirstName())));
subQuery1.setProjection(Projections.property("formId"));

DetachedCriteria subQuery2 = DetachedCriteria.forClass(Response.class);
subQuery2.add(Restrictions.and(
    Restrictions.eq("id", "lastName").add(
    Restrictions.eq("value", getLastName())));
subQuery2.setProjection(Projections.property("formId"));
criteria.add(Restrictions.and(Subqueries.propertyIn("id", subQuery1),
                Subqueries.propertyIn("id", subQuery2)));