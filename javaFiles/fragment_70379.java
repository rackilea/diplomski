public static String getAuth () {
    // Declare authServer with method scope, and initialize it.
    String authServer;
    Connection connection = null;
    try {
        connection = ConnectionConfig.getConnection();
        if (connection != null) {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT auth FROM auth");
            while (rs.next()) {
                // Just assign to authServer here rather than declaring
                // and initializing it.
                authServer = rs.getString("auth");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return authServer;
    }
}