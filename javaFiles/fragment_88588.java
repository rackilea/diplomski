Session session = factory.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        session.save(mc);
        tx.commit(); // Flush happens automatically
    }
    catch (RuntimeException e) {
        tx.rollback();
        throw e; // or display error message
    }
    finally {
        session.close();
    }