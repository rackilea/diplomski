EntityManager entityManager = getOrCreateEntityManager();
try {
  entityManager.getTransaction().begin();
  // do something
  entityManager.getTransaction().commit();
}
catch ( Exception e ) {
  if ( entityManager != null && entityManager.getTransaction.isActive() ) {
    entityManager.getTransaction().rollback();
  }
  throw e;
}
finally {
  if ( entityManager != null ) {
    entityManager.close();
  }
}