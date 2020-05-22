Transaction tx = null;
try {
    tx = session.beginTransaction()
    Profesor p2 = (Profesor) session.merge(p);
    session.saveOrUpdate(p2);
    tx.commit();
} catch(Exception e) {
    tx.rollback();
}