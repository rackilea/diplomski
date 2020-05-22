PreparedStatement ps = null;
 try {
    conn = getConnection();
    ps = conn.prepareStatement(myQuery, PreparedStatement.RETURN_GENERATED_KEYS);
    ps.setInt(1, anInteger);
    ...
    int rows = ps.executeUpdate();
    if (rows == 1) {
        ResultSet keysRS = ps.getGeneratedKeys();
        if (keysRS.next())
            int id = keysRS.getInt(1) // Get generated id