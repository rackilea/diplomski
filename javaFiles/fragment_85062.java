em = emf.createEntityManager();
tx = em.getTransaction();
tx.begin();   // now a transaction is active
start();      // call your method
// call other methods...
tx.commit();  // now the update is actually done
em.close();