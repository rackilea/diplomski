Criteria c = session.createCriteria(User.class);
Criteria nc = c.createCriteria("notes", "note");
nc.add("bookId", 1);

ProjectionList pl = Projections.projectionList();
pl.add(Projections.distinct(Projections.property("userId")));
pl.add(Projections.property("name"));
pl.add(Projections.property("familyName"));
c.setProjection(pl);

List<Object[]> result = (List<Object[]>) c.list();