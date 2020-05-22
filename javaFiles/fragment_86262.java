CriteriaBuilder cb /* = ... */;
CriteriaQuery<Tuple> query = cb.createTupleQuery();
Root<Upload> root = query.from(Somewhere.class);
query.groupBy(cb.function("weekdiff",
    Integer.class,
    root.get("creationDate"),
    cb.parameter(String.class, "refDate")).alias("week")
);