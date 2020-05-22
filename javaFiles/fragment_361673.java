interface MyCrazyGenericThing<T> {
    T uniqueResult(Session session);
}

class MyCrazyFunctionThing implements MyCrazyGenericThing<User> {
    User uniqueResult(Session session) {
        Query query = session.createQuery(this.sql);
        query.setString("id", this.id);
        return query.uniqueResult();
    }
}

<T> T DatabaseGateway::execute(MyCrazyGenericThing<T> q) {
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.getTransaction();

    try {
        tx.begin();
        T result = q.uniqueResult(session)
        tx.commit();

        return result;
    } catch (...) {
        // ...
    }
}