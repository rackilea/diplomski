Criteria crit=session.createCriteria(BiMembres.class);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.add(Restrictions.eq("login", this.login));
       ... OTHER Criterias if any..
       //set the count projection
      crit.setProjection(Projections.rowCount())
   Long rowsCount = (Long)crit.uniqueResult();