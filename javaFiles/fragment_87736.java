SessionFactory sessionFactory = null;
    Session session = null;
    try {
        sessionFactory = getHibernateTemplate().getSessionFactory();
        session = SessionFactoryUtils.getSession(sessionFactory, true);
        Query query = session.getNamedQuery("updateAField");

        query.setParameterList("states", states);

        int updatedCount = query.executeUpdate();
        return updatedCount;
    } catch (Exception e) {
        logger.error(e.toString());
        throw new Throwable(e);
    } finally {
        if (session != null) {
            SessionFactoryUtils.closeSession(session);
        }
    }