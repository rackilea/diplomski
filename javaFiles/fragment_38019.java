Session session = sessionFactory.openSession();

FullTextSession fullTextSession = Search.getFullTextSession(session);
fullTextSession.createIndexer().startAndWait();

QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Employee.class).get();
org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("name").matching(name).createQuery();
org.hibernate.search.FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Employee.class);
fullTextQuery.setProjection("name");

List list = fullTextQuery.list();