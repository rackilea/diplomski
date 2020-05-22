Connection conn = ... // get from jndi
Session session = sessionFactory.openSession(connection);
try{
   Transaction tx = new Transaction(); // 
   //do some work with either hte connection or the session or both
   tx.commit();
}finally{
   session.close();
   conn.close();
}