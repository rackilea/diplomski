Session session = this.sessionFactory.getCurrentSession();

Criteria criteria = session.createCriteria(UserBalanceLog.class, "ubl");
criteria.createAlias("ubl.adminId", "a");

criteria.setProjection(Projections.projectionList().add(Projections.property("balance").as("balance")).add(Projections.property("balanceType").as("balanceType")).add(Projections.property("message").as("message")).add(Projections.property("dateCreated").as("dateCreated")).add(Projections.property("a.username").as("username")));
criteria.addOrder(Order.desc("id"));

if (parameters.get("userId") != null) {
    criteria.add(Restrictions.eq("userId", new Integer(parameters.get("userId"))));
}

if (parameters.get("balanceType") != null) {
    criteria.add(Restrictions.eq("balanceType", parameters.get("balanceType")));
}

if (parameters.get("dateCreated") != null) {
    criteria.add(Restrictions.eq("dateCreated", parameters.get("dateCreated")));
}

criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

criteria.setFirstResult(start);
criteria.setMaxResults(Pagination.limitPerPage);
List userBalanceList = criteria.list();