EntityManager em = getDb().getEntityManager();
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Child> criteria = cb.createQuery(Child.class);
Root<Parent> p = criteria.from(Parent.class);
Root<Child> c = criteria.from(Child.class);
Predicate condition = cb.and(
    cb.equal(c.get(Child_.parentId), p.get(Parent_.id)),
    ...
    );
criteria.where(condition);
criteria.select(c);
criteria.orderBy(cb.asc(c.get(Child_.createDate)));
TypedQuery<Child> q = em.createQuery(criteria).setMaxResults(limit);