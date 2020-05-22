public static int insertInDB(String sqlQuery) {
        Connection conn = getDBConnection();
        ResultSet rs = null;
        int id = 0;
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(sqlQuery);
            Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt1.executeQuery("select last_insert_id()");
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            closeDBConnection();
        }
        return id;
    }