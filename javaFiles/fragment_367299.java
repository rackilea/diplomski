Map<String,Object> aliasToValueMap = 
    session.createCriteria(User.class)
      .add(Restrictions.idEq(userID))
      .setProjection(Projections.projectionList()
        .add(Projections.id().as("id"))
        // Add others properties
      )
      .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE)
    .uniqueResult();