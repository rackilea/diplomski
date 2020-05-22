Connection conn;

void createTables() throws SQLException {
    try (Statement stmt = conn.createStatement()) {
        String sql = "CREATE TABLE ABC(" +
                     "abc_ID int NOT NULL AUTO_INCREMENT," +
                     "abc_Name varchar(50)," +
                     "PRIMARY KEY (abc_ID))";
        stmt.executeUpdate(sql);
    }
}