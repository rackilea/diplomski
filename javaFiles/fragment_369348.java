Session session = sessionFactory.openSession();
try {
   session.beginTransaction();
   try {   
      doHibernateStuff(session);
      session.getTransaction().commit(); 
   } catch (Exception e) {
      session.getTransaction().rollback();
      throw e;
   } 
} finally {
   session.close();
}