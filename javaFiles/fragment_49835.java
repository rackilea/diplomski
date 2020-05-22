public List<Row> list() throws SQLException {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    List<Row> rows = new ArrayList<Row>();

    try {
        connection = database.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(SQL_LIST);
        while (resultSet.next()) {
            Row row = new Row();
            row.setName(resultSet.getString("name"));
            // ...
            rows.add(row);
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }

    return rows;
}