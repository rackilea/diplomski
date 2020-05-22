em.getTransaciton().begin();
try {
  Query query = em.createNativeQuery("DELETE FROM table1 WHERE theId = 10;");
  query.executeUpdate(); //not yet executed until transaction is commited.

  //continue do something...

  em.getTransaction().commit(); //the query above is executed here finally
} catch (ex RuntimeException) {
  em.getTransaction().rollback();
} finally {
  // you probably also want something here to check the status of the transaction and rollback if you exited the try block somehow
}