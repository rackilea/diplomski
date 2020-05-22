Criteria criteria = 
    getSession()
        .createCriteria(SaleRecord.class)
        .add(Restrictions.between("date", 
                                  reportForm.getFromDate(), 
                                  reportForm.getToDate()));

        .setProjection(Projections.projectionList()
            .add(Projections.property("type"), "accountName")
            .add(Projections.sum("amount"))
            .add(Projections.groupProperty("type")));
        .setResultTransformer(Transformers.aliasToBean(CollectionDO.class))
return (List<CollectionDO>) criteria.list();