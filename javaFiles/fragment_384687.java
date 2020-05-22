public List<Row> findByStartDate(Date date) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Row> criteria = cb.createQuery(Row.class);
    Root<Row> r = criteria.from(Row.class);
    Predicate dateEquals = cb.equal(r.get("startDate"), date);
    criteria.select(r).where(dateEquals);
    return entityManager.createQuery(criteria).getResultList();
}