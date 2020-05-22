public static void queryDB(String query, Consumer<ResultSet> processor) {
    try (
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Settings.SQLITE_DB_PATH);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    ) {
        processor.accept(resultSet);
    } catch (SQLException ex) {
        Logger.getLogger(SQLInterp.class.getName()).log(Level.SEVERE, null, ex);
    }
}