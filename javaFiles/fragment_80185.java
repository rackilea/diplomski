void executeWork(WorkInterface work) {
Session sess = factory.openSession();
 Transaction tx;
 try {
     tx = sess.beginTransaction();

     work.execute();

     tx.commit();
 }
 catch (Exception e) {
     if (tx!=null) tx.rollback();
     throw e;
 }
 finally {
     sess.close();
 }