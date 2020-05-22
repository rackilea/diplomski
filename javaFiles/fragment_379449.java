Criteria accountCriteria = getCurrentSession().createCriteria(Account.class,"acc");
Criteria bookCriteria =  accountCriteria .createCriteria("book","b");
Criteria orgCriteria =  bookCriteria.createCriteria("organization","org");
orgCriteria.add(Restrictions.eq("name", "XYZ"));

ProjectionList properties = Projections.projectionList();
properties.add(Projections.property("name"));
properties.add(Projections.property("id"));

accountCriteria.setProjection(properties);
accountCriteria.list();