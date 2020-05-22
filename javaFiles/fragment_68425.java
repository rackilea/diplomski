class DbUtil {
    public void closeQuietly(ResultSet rs) {
      try {
         if (rs != null) rs.close();
      }
      catch (Exception ignored) {}
    }

    public void closeQuietly(Statement stmt) {
      try {
         if (stmt != null) stmt.close();
      }
      catch (Exception ignored) {}
    }
}