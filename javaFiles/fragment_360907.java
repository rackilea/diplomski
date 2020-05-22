Session sess = factory.openSession();
Transaction tx = null;
try {
    tx = sess.beginTransaction();
    //do some work, point 3
    tx.commit();
} catch (Exception e) {
    if (tx!=null) tx.rollback();
    throw e;
} finally {
    sess.close();
}