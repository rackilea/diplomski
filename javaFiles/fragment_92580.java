public Connection createConnection() throws SQLException {
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost/highscores", "root", "root");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        throw new SQLException("Unable to load JDBC driver", ex);
    }
    return con;
}

public void makeQuery() throws SQLException {

    try (Connection con = createConnection()) {
        try (PreparedStatement stmt = con.prepareStatement("...")) {
            // Fill in parameters to the statement
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Get the results
                }
            }
        }
    }

}