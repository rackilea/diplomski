String queryString = dynamicallyComposeQueryForConditions(someConditions);
String countQueryString = QueryUtils.createCountQueryFor(queryString);
Query query = entityManager.createQuery(queryString);
Query countQuery = entityManager.createQuery(countQueryString);
query.setParameter("foo", foo);
query.setParameter("bar", bar);
countQuery.setParameter("foo", foo);
countQuery.setParameter("bar", bar);
query.setFirstResult((int) pageable.getOffset());
query.setMaxResults(pageable.getPageSize());
return PageableExecutionUtils.getPage(query.getResultList(), pageable,
        () -> (long) countQuery.getSingleResult());