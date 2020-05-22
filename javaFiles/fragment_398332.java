try (Connection conn = Database.getConnection(); Statement st = conn.createStatement();
     ResultSet set = st.executeQuery("SELECT * FROM THING")) {
   // Your "try" code as before
}
catch (SQLException e) {
   // Handle as before
}
// No "finally" to clean up resources needed!