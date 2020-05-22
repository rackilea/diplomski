CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<B> cq = builder.createQuery(B.class);
    Root<B> fromB = cq.from(B.class);

    Expression<DateTime> lastmodifiedDate = fromB.get(B_.lastmodifiedDate);
    Expression<DateTime> retentionDate = fromB.get(B_.a).get("retentionDate");
    Expression<Integer> days = fromB.get(B_.a).get("days");

    ParameterExpression<String> dayUnit = builder.parameter(String.class, "dayUnit");
    Expression<DateTime> newDate = builder.function("DATEADD", DateTime.class, dayUnit, days, retentionDate);

    cq.where(builder.greaterThanOrEqualTo(newDate, lastmodifiedDate));

    TypedQuery<B> tq = entityManager.createQuery(cq.select(fromB));
    tq.setParameter("dayUnit", "DAY");
    List<B> results = tq.getResultList();