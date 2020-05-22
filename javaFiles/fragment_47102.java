public boolean checkUserExistence(String login) {
    String sql = "select u.id from user u where u.login = ?";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, login);
    ResultSet rs = stmt.executeQuery();
    return rs.next();
}