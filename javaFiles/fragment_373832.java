@Provides
@ServiceOne
@Inject
protected JPQLQuery provideJPQLQuery(EntityManager entityManager) {
    return new JPAQuery(entityManager);
}