EntityManager em = getEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);

    emp.fetch(Employee_.domain, JoinType.LEFT);

    cq.where(cb.or(emp.get(Employee_.organization).isNull(),
            cb.equal(emp.get(Employee_.organization).get(InternalOrg_.code), "1")));

    return em.createQuery(cq).getResultList();