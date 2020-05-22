private static final String SQL_SUBLIST = "SELECT id, username, job, place FROM"
    + " (SELECT row_number() OVER (ORDER BY id) AS row, id, username, job, place"
    + " FROM contact) AS temp WHERE row BETWEEN %d AND %d";

public List<Contact> list(int firstrow, int rowcount) {
    String sql = String.format(SQL_SUBLIST, firstrow, firstrow + rowcount);

    // Implement JDBC.
    return contacts;
}