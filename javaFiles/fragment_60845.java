CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
Root root = criteriaQuery.from(/*The class youre searching*/);
Predicate predicate = criteriaBuilder.like(root.<String>get(/*field name*/), /*search values*/);
criteriaQuery.where(predicate);
criteriaQuery.select(root);
TypedQuery query = entityManager.createQuery(criteriaQuery);
List<T> result = query.getResultList();