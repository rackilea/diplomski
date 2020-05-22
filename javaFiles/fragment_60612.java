public void cutoffOrders(  ) throws Exception {
  Transaction tx = null;
  try {
      tx = getSession().beginTransaction();
      getSession().setFlushMode(FlushMode.MANUAL);
      getImpl().cutOffFoos(fooTime);
      getSession().flush();
      tx.commit();
  } catch (StaleObjectStateException e1){
      if (tx != null) tx.rollback();
      logger.error( "Failed to cutoff order : " + e1 );
      throw new Exception( LocaleMgr.getMessage());
  } 
    finally {
      // reset implementation object, close session,
      // and reset session object
      impl = null;
      sess.close();
      sess = null;
  }   
}