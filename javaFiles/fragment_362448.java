AuditQuery query = getAuditReader().createQuery().forRevisionsOfEntity(
            entityClass, false, false);
    query.add(AuditEntity.revisionNumber().le(revision));
    query.add(AuditEntity.revisionNumber().maximize()
            .computeAggregationInInstanceContext());
    query.addOrder(AuditEntity.revisionNumber().desc());
    return query.getResultList();