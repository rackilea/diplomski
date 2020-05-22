Transaction tx = null;
    tx = session.beginTransaction();
    boolean b = false;
    if (b == false) {
        Query query = session
                .createQuery(" update Issue set dueStatus = 'true' where returnDate='"
                        + a + "'");
    query.executeUpdate();
    tx.commit();