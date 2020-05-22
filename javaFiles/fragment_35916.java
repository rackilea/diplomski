Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet res = null;
    try {
        conn = ds.getConnection();
        stmt = conn.prepareStatement(sqlStatement);
        //
        // ....
        res = stmt.executeQuery();

        // use the resultset

        conn.commit();
    } catch (SQLException e) {
        // Manage the exception
        try {
            conn.rollback();
        } catch (SQLException e1) {
            // SWALLOW
        }

    } finally {
        close(res);
        close(stmt);
        close(conn);
    }