public void download(String table, Writer responseWriter) throws SQLException, IOException {
    // get list of all allowed tables
    List<String> fileList = getAllowedTables();
    if (!fileList.contains(table)) {
        throw new IllegalAccessException("Someone tried to access a forbidden table.");
    }

    try (Connection conn = dataSource.getConnection()) {
        CopyManager copyManager = new CopyManager(conn.unwrap(BaseConnection.class));
        // SQL Injection can happen here!
        String statement = "COPY " + table + " TO STDOUT WITH NULL ''";
        copyManager.copyOut(statement, responseWriter);
    }
}