PersistenceManager pm = PMF.getInstance().getPersistenceManager();
Transaction tx = pm.currentTransaction();
try {
    tx.begin();
    pm.makePersistent(t);
    tx.commit();
} catch (Exception e) {
    LOGGER.severe("Exception by creating a new entity "
            + e.getMessage());
    tx.rollback();
} finally {
    pm.close();
}