try {
    String nativeSql = "Some random non-sql stuff";
    Session sess = sessionFactory.openSession();
    List <?> result = sess.createSQLQuery(nativeSql).list();
} catch (JDBCException e) {
    SQLException sqlException = e.getSQLException;
    if (sqlException instanceof PSQLException) {
        PSQLException psqlException = (PSQLException) sqlException;
        // ... work with psqlException ...
    }
}