Criteria criteria = session.createCriteria(Cats.class,"c");
criteria.add(Restrictions.isNull("breed.pkBreed"));
criteria.createCriteria("owner","o",JoinType.RIGHT_OUTER_JOIN,Restrictions.eq(c.breed.desc,"Egyptian cat"))
    .setProjection(Projections.projectionList()
        .add(Projections.property("o.pkOwner").as("pkOwner"))
        .add(Projections.property("o.name").as("name"))
    .setResultTransformer(Transformers.aliasToBean(Owners.class));
List<Owners> list=criteria.list();