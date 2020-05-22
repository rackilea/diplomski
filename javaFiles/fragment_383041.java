@Transactional
public List<CriticalComponent> searchForCriticalComponent(String searchTerm){

    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(CriticalComponent.class).get();
    //Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("criticalFilename", "itemCode", "serviceName").matching(searchTerm).createQuery();
    Query luceneQuery = qb.keyword().wildcard().onFields("criticalFilename","serviceName","item.itemCode").matching(searchTerm.toLowerCase()+'*').createQuery();

    javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, CriticalComponent.class);

    List<CriticalComponent> criticalComponentsModel = null;
    try {
        criticalComponentsModel  = jpaQuery.getResultList();
    } catch (NoResultException nre) {
        log.debug("Search: No result found");
    }
    return criticalComponentsModel;
}