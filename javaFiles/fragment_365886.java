public boolean isValidateUser(String username, String password) throws SQLException {
    boolean result = false;

    String query = "SELECT * FROM  user WHERE username='?' and password='?'";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, username);
    ps.setString(2, password);

    ResultSet rs = ps.executeQuery();

    if (rs.next() == true) {
       result = true;
    }

    return result;
}