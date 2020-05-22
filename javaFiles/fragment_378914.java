java.sql.PreparedStatement stmt = conne.prepareStatement(
  "INSERT INTO kun(name,statusLocation,text,source) VALUES(?,?,?,?)");
stmt.setString(1, status.getUser().getScreenName());
stmt.setString(2, user.getLocation());
stmt.setString(3, status.getText());
stmt.setString(4, status.getSource());
stmt.executeUpdate();