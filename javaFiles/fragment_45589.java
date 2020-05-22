CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Run> cq = cb.createQuery(Run.class);
    Root<Run> root = cq.from(Run.class);

    Expression<String> second = new UnitExpression(null, String.class, "SECOND");
    Expression<Integer> timeDiff = cb.function(
        "TIMESTAMPDIFF",
        Integer.class,
        second,
        root.<Timestamp>get(Run_.endTime),
        root.<Timestamp>get(Run_.startTime));
    List<Predicate> conditions = new ArrayList<>();
    conditions.add(cb.greaterThan(timeDiff, 60));
    cq.where(conditions.toArray(new Predicate[]{}));
    return session.createQuery(cq);