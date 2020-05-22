FullTextEntityManager ftem = Search.getFullTextEntityManager(entityManager); 
QueryBuilder qb = ftem.getSearchFactory().buildQueryBuilder().forEntity(Bibliographic.class).get();   
Query q = qb.simpleQueryString()
    .onFields("title", "abstract")
    .matching(queryString)
    .createQuery();
FullTextQuery query = ftem.createFullTextQuery(q, Bibliographic.class).setFirstResult(start).setMaxResults(rows);