private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory f){
    this.sessionFactory = f;
}

public void saveOrUpdate(BaseDomainModel baseObject) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(baseObject);
}