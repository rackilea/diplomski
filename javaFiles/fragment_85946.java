try {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {                
            transaction.rollback(); 
            throw e; // optional if you want to manage the exception higher up                         
        } finally {
          entityManager.close(); // optional if you also manage you EM creation manually.
         }