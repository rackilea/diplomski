targetText="بةرز";
try (PreparedStatement ps = conn.prepareStatement(
   "SELECT English,Kurdish FROM Info " +
   "WHERE Kurdish = ? " +
   "OR REGEXP_MATCHES(Kurdish, ?) " +
   "OR REGEXP_MATCHES(Kurdish, ?) " +
   "OR REGEXP_MATCHES(Kurdish, ?) ")) {
   ps.setString(1, targetText);
   ps.setString(2, "^" + targetText+ "[ ]*(،)[.]*");
   ps.setString(3, "[.]*(،)[ ]*" + targetText+ "$");
   ps.setString(4, "[.]*(،)[ ]*" + targetText+ "[ ]*(،)[.]*");
   try (ResultSet rSet = ps.executeQuery()) {
      while (rSet.next()) {
         System.out.println(rSet.getString("English"));
         System.out.println(rSet.getString("Kurdish"));
      }
   }
}