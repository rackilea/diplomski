private <T> CriteriaQuery<T> genericCriteria(ReportFilter reportFilter, Class<T> clazz) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> c = cb.createQuery(clazz);
    ....
    if (clazz.equals(ResultSetType.class)) {
        c.multiselect(...);
    } else {
    }
    ...
    return c;
}