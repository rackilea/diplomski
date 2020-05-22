ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

ResultSetMetaData rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();

// test the number of columns returned
if (numberOfColumns == 5) {
    //
} else {
    // numberOfColumns = 7
}

// or, test the column names
if ("col3".equals(rsmd.getColumnName(3)) {
    // col3 exists
}