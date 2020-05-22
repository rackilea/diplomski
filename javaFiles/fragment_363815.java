protected static void storeObject(Object object) throws DAOException {
  Transaction tx = null;
  try {
    Session session = Helper.getHibernateSession();
    session.saveOrUpdate(object);
    tx = session.beginTransaction();
    session.flush();
    tx.commit();
  } catch (HibernateException he) {
    if(tx != null){
      tx.rollback();
    } 
    throw new DAOException(he);
  }
}