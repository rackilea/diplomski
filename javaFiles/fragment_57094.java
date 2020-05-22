public void testPersistTwoExpertiseAreasWithTheSameNameIsNotAllowed(){
    ExpertiseArea ea = new ExpertiseArea("Design");
    ExpertiseArea otherEA = new ExpertiseArea("Design");

    SessionFactory sf = getSessionFactory();
    Session session = sf.openSession();
    Transaction txn = session.beginTransaction();
    try {
        ead.setSession(session);
        ead.makePersistent(ea);
        // no ExpertiseArea by this name in DB, this should commit
        txn.commit(); 
    } catch (HibernateException ex) {
        txn.rollback();
        fail("Unexpected exception " + ex);
    } finally {
        session.close();
        ead.setSession(null);
    }
    session = sf.openSession();
    txn = session.beginTransaction();
    try {
        ead.setSession(session);
        ead.makePersistent(otherEA);
        // this should fail 'cos there is already an ExpertiseArea with
        // the same name in DB
        txn.commit();
        fail("Expected constraint violation exception");
    } finally {
        session.close();
        ead.setSession(null);
    }
}