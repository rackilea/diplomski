private static final String SQL_SUBLIST = "SELECT id, username, job, place FROM"
    + " (SELECT id, username, job, place FROM contact ORDER BY id)"
    + " WHERE ROWNUM BETWEEN %d AND %d";

public List<Contact> list(int firstrow, int rowcount) {
    String sql = String.format(SQL_SUBLIST, firstrow, firstrow + rowcount);

    // Implement JDBC.
    return contacts;
}