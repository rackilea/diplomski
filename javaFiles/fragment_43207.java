public User findUserById(int userId) {
   Session session = HibernateUtil.getSessionFactory().openSession();
   String queryString = "from User where userId = :userId";  
   Query query = session.createQuery(queryString);  
   query.setInteger("userId", userId);  
   Object queryResult = query.uniqueResult();  
   UserDAO user = (UserDAO)queryResult;
}