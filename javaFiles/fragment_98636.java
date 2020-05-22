Session session = getSessionFactory().openSession();

   MyObject currentState = (MyObject) 
           session.get(MyObject.class, id, 
                       new LockOptions(LockMode.PESSIMISTIC_WRITE));

   if (!statusToUpdateTo.equals(currentState.getStatus())) {
     tx = session.beginTransaction();

     currentState.setStatus(statusToUpdateTo);
     session.save(currentState);

     tx.commit();
   } else {
     // Seems to clear lock
     tx = session.beginTransaction();
     tx.rollback();
   }

   session.close();