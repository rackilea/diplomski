public void save(Example example) {
    Session session = null;
    Transaction tx=null;
    try {
        log.info( example.toString());
        session = this.sessionFactory.openSession();
        tx = session.beginTransaction();
        session.persist(example);
        tx.commit();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {

     if (!tx.wasCommitted()) {
     tx.rollback();
     }//not much doing but a good practice
     session.flush(); //this is where I think things will start working.
     session.close();
    }
}