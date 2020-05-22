// TODO: Close the statement, e.g. using a try-with-resources statement
// or a finally block.
PreparedStatement statement =
    conn.prepareStatement("SELECT * FROM Table WHERE Date between ? and ?");
statement.setDate(1, fromDate);
statement.setDate(2, toDate);
ResultSet results = statement.executeQuery();
// Use the results