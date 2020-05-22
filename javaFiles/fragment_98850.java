public static boolean isAdmin(String email) {

boolean check = false;
PreparedStatement pst = null;  
ResultSet rs = null;  
try(Connection conn= ConnectionConfiguration.getConnection()){
    pst = conn.prepareStatement("SELECT * FROM users WHERE email =? and role='admin';");  
    pst.setString(1, email);  
    rs = pst.executeQuery();
   check = rs.next(); // if the resultSet has results, then check will evaluate to true

} catch (SQLException e) {
    e.printStackTrace();
}
return check;  
}