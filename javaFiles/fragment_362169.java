public List < Object > retrieveAll(Object obj) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery < Object > cq = cb.createQuery(Object.class);
    Root < Object > objQuery = cq.from(Object.class);

    List < Predicate > predicates = new ArrayList < Predicate > ();

    // You can add as many as Predicate you want.
    if (null != obj.getName() && !obj.getName().isEmpty()) {
        predicates.add(cb.equal(objQuery.get("Name"), obj.getName()));
    }

    List < Object > results = new ArrayList < Object > ();
    if (!predicates.isEmpty()) {
        cq.select(objQuery).where(predicates.toArray(new Predicate[] {}));
        cq.orderBy(cb.asc(objQuery.get("Name")));
        results = entityManager.createQuery(cq).getResultList();
    } else {
        results = entityManager.createQuery("from Emplyee ORDER BY Name asc").getResultList();
    }
    return results;
}