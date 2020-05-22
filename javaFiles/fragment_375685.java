public List getSelectList(String query) throws Exception {

    Session session = sessionFactory.createSession();

    try {
        session.beginTransaction();
        List list = session.createQuery(query).list();
        session.getTransaction().commit();
        return list ;
    } catch (Exception e) {
        Transaction tx = session.getTransaction();
        if (tx != null) {
            tx.rollback();
        }
        throw e ;
    }
}