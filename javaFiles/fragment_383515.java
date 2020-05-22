DetachedCriteria subquery = DetachedCriteria.forClass(Person.class)
        .add(Restrictions.like("name", "%" + nameContains + "%"))
        .setProjection(Projections.distinct(Projections.property("personType.id")))
        ;
return session.createCriteria(PersonType.class)
        .add(Subqueries.propertyIn("id", subquery))
        .list()
        ;