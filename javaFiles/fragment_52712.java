Root<SearchIn> root = criteriaQuery.from(SearchIn.class);
Join<SearchIn, Take> takeJoin = root.join(SearchIn_.takes);
criteriaQuery.where(builder.equal(root.get(SearchIn_.searchString), "bla"));


TypedQuery<SearchIn> typedQuery = entityManager.createQuery(criteriaQuery);
return typedQuery.getResultList();