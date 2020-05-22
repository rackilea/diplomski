String sql = "SELECT value FROM table WHERE check = ?";

Connection conn = DriverManger.createConnection (...)
PreparedStatement stmt = conn.prepareStatement(sql);
stmt.setString(1, condition);

ResultSet rset = stmt.executeQuery();
if (rset.next()) {   // or, for multiple results: while(rset.next()) {
    String result = rset.getString("value");
    // TODO use `result`
}  // else for error mesage (not found)