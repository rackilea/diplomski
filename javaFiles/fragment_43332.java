public Serializable saveObject(E object) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction trans = session.beginTransaction();
    try {           
        Serializable id = session.save(object);
        session.flush();
        trans.commit();
        return id;
    } catch (Exception e) {
        e.printStackTrace();
        session.flush();
        trans.rollback();
        return null;
    }
}