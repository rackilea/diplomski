public List<Data> list() {
    Session session = HibHelper.getSessionFactory().openSession();
    session.beginTransaction();

    List<Data> userList = null;

    try {
        userList = (List<Data>) session.createQuery("from Data").list();

                if(!session.getTransaction.wasCommitted()){
                    session.getTransaction.commit()
                    }
    } catch (HibernateException e) {
        e.printStackTrace();
        session.getTransaction().rollback();
    }
    session.close();
    return userList;
}