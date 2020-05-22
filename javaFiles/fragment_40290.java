public void prepare() throws Exception {
    // initialize DAO Objects with Session and Transaction

    if (session == null)
    {
        session = com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory.getNewSession();
        if (!session.isOpen())
            throw new NullPointerException("Fix the code: session's not here");

        transaction = session.beginTransaction();
    }
    _feedGroupDao = new FeedGroupDAO(session,transaction); // init more DAOs with the same session/transaction