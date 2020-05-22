CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<PlanTacticBuyFile> q = builder.createQuery(PlanTacticBuyFile.class);
Root<PlanTacticBuyFile> c = q.from(PlanTacticBuyFile.class);

ParameterExpression<Date> date = builder.parameter(Date.class, "startDate");
q.where(builder.and(c.get("tacticId").in(ids),
        builder.between(date, c.get("startDate"), c.get("endDate"))));
...

em.createQuery(q).setParameter("startDate", startDate).getResultList();