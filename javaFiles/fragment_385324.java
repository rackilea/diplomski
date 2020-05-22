Criteria cr = session.createCriteria(User.class)
    .setProjection(Projections.projectionList()
      .add(Projections.property("id"), "id")
      .add(Projections.property("Name"), "Name"))
    .setResultTransformer(Transformers.aliasToBean(User.class));

  List<User> list = cr.list();