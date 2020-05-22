public static List<Map<String, Object>> queryDB2(String query) {
    try (
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Settings.SQLITE_DB_PATH);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    ) {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] name = new String[columnCount];
        for (int i = 0; i < columnCount; i++)
            name[i] = metaData.getColumnLabel(i + 1);
        List<Map<String, Object>> rows = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> row = new LinkedHashMap<>();
            for (int i = 0; i < columnCount; i++)
                row.put(name[i], resultSet.getObject(i + 1));
            rows.add(row);
        }
        return rows;
    } catch (SQLException ex) {
        Logger.getLogger(SQLInterp.class.getName()).log(Level.SEVERE, null, ex);
    }
}