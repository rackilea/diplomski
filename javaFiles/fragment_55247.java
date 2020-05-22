CriteriaBuilder builder = entityManager.getCriteriaBuilder();

CriteriaQuery<Long> countCriteriaQuery = builder.createQuery( Long.class );
countCriteriaQuery.select( builder.countDistinct( countQuery.from( MyClass.class ) ) );

TypedQuery<Long> countQuery = entityManager.createQuery( countCriteriaQuery );
int totalObjectsNumber = countQuery.getSingleResult().longValue();