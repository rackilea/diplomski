User MyCrazyFunctionThing::uniqueResult(Session session) {
    Query query = session.createQuery(this.sql);
    query.setString("id", this.id);
    return query.uniqueResult();
}

User DatabaseGateway::execute(MyCrazyFunctionThing q) {
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.getTransaction();

    try {
        tx.begin();
        User user = q.uniqueResult(session)
        tx.commit();

        return user;
    } catch (...) {
        // ...
    }
}