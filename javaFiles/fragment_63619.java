PreparedStatement ps = connection.prepareStatement("select name, username, password "+
  "from securitysystem.employee where username = ? and password = ?");
ps.setString(1, username);
ps.setString(2, password);

ResultSet rs = ps.executeQuery();