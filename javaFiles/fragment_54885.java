public static EntityManager getEntityManager() {
    EntityManager entityManager;
    try {
        entityManager = threadLocal.get();

        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = emf.createEntityManager();
            threadLocal.set(entityManager);

        }
    } catch (Throwable ex) {
        logger.info("JPAUtil Exception", ex);
        throw new ExceptionInInitializerError(ex);
    }
    return entityManager;
}