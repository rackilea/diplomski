DetachedCriteria field2List = DetachedCriteria.forClass(Table2.class, "t2").
  setProjection(Projections.distinct(Projections.property("t2.id.field2"))).
  add(Subqueries.propertyIn("t2.id.field3",field4List));

List<Table1> results = session.createCriteria(Table1.class, "t1").
  add(Subqueries.propertyIn("t1.id.field1",field2List)).list();