CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

// select a from A a 
CriteriaQuery<A> queryA = criteriaBuilder.createQuery(A.class);
Root<A> rootA = queryA.from(A.class);
queryA.select(rootA);

// Select distinct aId from B
CriteriaQuery<B> subQueryB = queryA.subquery(B.class);
Root<B> rootB = subQueryB.from(B.class);
bQuery.select(rootB.get("a")).distinct(true);

queryA.where(criteriaBuilder.not(criteriaBuilder.in(rootA.get("id").value(subQueryB))));

TypedQuery<A> query = entityManager.createQuery(aQuery);
List<A> result = query.getResultList();