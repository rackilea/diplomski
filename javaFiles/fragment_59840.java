int id = 1;
String name = "gord";
String sql = "INSERT INTO people (id, name) VALUES (?, ?)";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setInt(1, id);
ps.setString(2, name);
ps.executeUpdate();