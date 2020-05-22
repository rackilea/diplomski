EntityManager em = null;
try {        
    em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    rows = em.createNativeQuery("UPDATE table SET ...").executeUpdate();
    em.getTransaction().commit();
} catch (Exception ex) {
    logger.error("Exception while scheduledOperation. Details: " + ex.getMessage());
    em.getTransaction().rollback();
} finally {
    if(em != null) {
        em.close();
    }
}