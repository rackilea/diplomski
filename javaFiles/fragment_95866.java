Session session = SessionFactoryUtils.getSession(
            getSessionFactory(), getEntityInterceptor(), getJdbcExceptionTranslator());
    SessionHolder sessionHolder = null;
    try {
        applyFlushMode(session, false);
        sessionHolder = new SessionHolder(session);
        TransactionSynchronizationManager.bindResource(getSessionFactory(), sessionHolder);
        Transaction t = getSessionFactory().getCurrentSession().beginTransaction();
        try {

            //execute your code here

            t.commit();
        } catch (Exception e) {
            t.rollback();
            log.error("Error", e);
        }
        try {
            flushIfNecessary(sessionHolder.getSession(), false);
        }
        catch (HibernateException ex) {
            throw convertHibernateAccessException(ex);
        }
    } finally {
        SessionFactoryUtils.closeSession(sessionHolder.getSession());
        TransactionSynchronizationManager.unbindResource(getSessionFactory());
    }