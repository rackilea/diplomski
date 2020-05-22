ResultSet rs = stmt.executeQuery();
if(rs.next()){
  String login = rs.getString("login");
  String password = rs.getString("password");
  int solde =rs.getInt("solde");
}