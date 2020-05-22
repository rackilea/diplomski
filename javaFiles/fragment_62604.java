Connection conn = ... // get from jndi
Session session = sessionFactory.openSession(connection);
try{
   //do some work with either hte connection or the session or both
}finally{
   session.close();
   conn.close();
}