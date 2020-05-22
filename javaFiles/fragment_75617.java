// Switch to transactional mode which actually triggers a SET autocommit = 0
con.setAutoCommit(false);
try {
    // Some operations on the db
    con.commit();
} finally {
    // Switch back to auto-commit mode which actually triggers a SET autocommit = 1
    con.setAutoCommit(true);
}