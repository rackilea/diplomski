public List<String> retrieveSQLQuery(String sqlQuery) throws SQLException {

    List<String> values = new ArrayList<>();

    try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery)) {

        while (rs.next()) {
            // this assumes that the passed-in query string has 
            // a "model" column in the SELECT clause
            values.add(rs.getString("model"));
        }
    }

    return values;        
}