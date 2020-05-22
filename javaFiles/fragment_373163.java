CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
CriteriaQuery<SELECTVALUETYPE> criteriaQuery = criteriaBuilder.createQuery(SELECTVALUETYPE.class);
Root<PARENTCLASS> root = criteriaQuery.from(PARENTCLASS.class);
criteriaQuery.select(root);
criteriaQuery.where(criteriaBuilder.equal(root.get(property), constraintValue));

Query<SELECTVALUETYPE> query = session.createQuery(criteriaQuery);