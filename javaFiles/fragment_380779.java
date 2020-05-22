public void save() throws Exception {
    List<T> processedEntities = new ArrayList<T>();
    EntityManager entityManager = getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction(); 
    transaction.begin();
    try {
        for(T entity : addedEntities) {
            entityManager.persist(entity);
            processedEntities.add(entity);
        }
        for(T entity : updatedEntities)
            entityManager.merge(entity);
        for(T entity : deletedEntities)
            entityManager.merge(entity);
        entityManager.flush();
        transaction.commit();
    } catch(Exception e) {
        updatedEntities.addAll(processedEntities);
        addedEntities.removeAll(processedEntities);

        if(transaction.isActive())
            transaction.rollback();
        throw e;
    }
    addedEntities.clear();
    updatedEntities.clear();
    deletedEntities.clear();
}