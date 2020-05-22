public List<String> retrieveAllColumnValues(Connection connection) throws SQLException {

    String query = "SELECT Names FROM MyTable";
    List<String> values = new ArrayList<>();

    try (Statement stmt = connection.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            values.add(rs.getString("Names"));
        }
        rs.close();
    }
    return values;
}