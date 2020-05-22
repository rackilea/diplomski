public static Transfer getTransferByID(int id){

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction T = null;
    Query Q = null;
    Transfer Result = null;
    Date D = null;

    try {
        T = session.beginTransaction();
        String query1 = "SELECT MAX(transfer.TDate) FROM Transfer transfer WHERE transfer.EmpID=:id GROUP BY transfer.EmpID";
        Q = session.createQuery(query1);
        Q.setInteger("id", id);
        D = (Date) Q.uniqueResult();
        String query2 = "FROM Transfer transfer WHERE transfer.EmpID=:id AND transfer.TDate=:dt";
        Q = session.createQuery(query2);
        Q.setInteger("id", id);
        Q.setDate("dt", D);
        Result = (Transfer) Q.uniqueResult();
        T.commit();
        return Result;

    } catch (HibernateException e) {
        if (T != null) T.rollback();
        return null;

    } catch (NullPointerException e) {
        if (T != null) T.rollback();
        return null;

    } finally {
        session.close();
    }
}