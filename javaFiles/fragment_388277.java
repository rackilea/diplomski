public List<Person> search(String keywordsList) throws DAOException {
    try {
        FullTextEntityManager fullTextEm = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder qb = fullTextEm.getSearchFactory().buildQueryBuilder().forEntity(Person.class).get();

        List<Query> queryList = new LinkedList<Query>();
        Query query = null;

        for (String keyword : keywordsList) {
            query = qb.keyword().onFields("name", "email", "username", "phone").matching(keyword).createQuery();
            queryList.add(query);
        }

        BooleanQuery finalQuery = new BooleanQuery();
        for (Query q : queryList) {
            finalQuery.add(q, Occur.MUST);
        }

        FullTextQuery fullTextQuery = fullTextEm.createFullTextQuery(query);
        fullTextQuery.setProjection("name", "email", "username", "phone");
        Sort sortField = new Sort(new SortField("name_order", SortField.STRING));
        fullTextQuery.setSort(sortField);
        return fullTextQuery.getResultList();
    }
    catch (Exception e) {
        logger.error("Error searching index: " + keywords, e);
        throw new DAOException(e);
    }
}