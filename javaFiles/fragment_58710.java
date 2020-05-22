public boolean isPatientExists(String usrename, Session session) {
    String sql = "SELECT 1 FROM Patient where user_name = :userName";
    SQLQuery query = session.createSQLQuery(sql);
    query.setParameter("userName", usrename);

    return query.list().size() > 0;
}