SessionFactory sessionFactory = null;
Session session = null;

try{
    do some stuff
catch(Exception e){

} finally {
  if (!sessionFactory.isClosed()) {
            session.close();
            sessionFactory.close();
       }
}