public static void close(Connection conn) {
    try {
        if (conn != null)
            conn.close();
    } catch (SQLException e) {
        // SWALLOW
    }
}

public static void close(Statement stmt) {
    try {
        if (stmt != null)

            stmt.close();
    } catch (SQLException e) {
        // SWALLOW
    }
}

public static void close(ResultSet res) {
    try {
        if (res != null)
            res.close();
    } catch (SQLException e) {
        // SWALLOW
    }
}