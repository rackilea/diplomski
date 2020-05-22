private static final String SQL_SUBLIST = "SELECT id, username, job, place FROM"
    + " contact ORDER BY id LIMIT %d OFFSET %d";

public List<Contact> list(int firstrow, int rowcount) {
    String sql = String.format(SQL_SUBLIST, firstrow, rowcount);

    // Implement JDBC.
    return contacts;
}