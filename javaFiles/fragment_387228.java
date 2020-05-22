sessionFactory = getHibernateTemplate().getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Query query = session
            .createQuery("select value from table where ...");
    query.setParameters("param1", value1);
    result = (Type) query.uniqueResult();