// your list of FooPks
List<FooPk> pkList = ....

//Create a criteria over an entity
Criteria  criteria = session.createCriteria(Foo.class);
// add a restriction
criteria.add(Restrictions.in("pk", pkList));
// Execute query and get result.
List<Foo> foos = criteria.list();