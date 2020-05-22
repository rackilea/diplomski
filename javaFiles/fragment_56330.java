PreparedStatement stmt = null;

    public void runQuery(String query) {
    Connection con = getConnection();       


    try {
    stmt = con.prepareStatement(query);
    stmt.execute();

    }
    catch(SQLException e) {
        e.printStackTrace();
    }
    finally {
        if(stmt != null && !stmt.isClosed()) {
            stmt.close();
        }

        if(con != null) {
        con.close();
        }
    }

}

public void cancelQuery() {
    try {
        if(stmt != null && !stmt.isClosed()) {
            stmt.cancel();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}