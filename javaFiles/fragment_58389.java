boolean userExists(String name, Connection conn) {
   PreparedStatement stmt = null;
   try{
      stmt = conn.prepareStatement("SELECT COUNT(Username) FROM User WHERE Username = ?");
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();
      rs.next();  // set cursor to first row
      int count = rs.getInt(1);
      rs.close();
      return count > 0;
   } catch(SQLException e) {
      // propagate error
      throw new RuntimeException(e);
   } finally {
      // clean up resources
      if (stmt != null) {
        try {
           stmt.close();
        } catch (SQLException ignore) {
           log("error on sql clean up", ignore);
        }
      }
   }
}