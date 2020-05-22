protected Session getSessionFactory() { // Accessible que par les classes
                                        // filles
    session = HibernateUtil.getSessionFactory().getCurrentSession();
    if(!session.getTransaction().isActive())
        session.beginTransaction();
    return session;
}