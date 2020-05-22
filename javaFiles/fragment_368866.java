final String query = "INSERT INTO users(user_id, username, biography) VALUES (?,?,?)";
final PreparedStatement ps = con.prepareStatement(query);
ps.setInt(1, user.getID());
ps.setString(2, user.getUsername());
ps.setString(3, user.getBiography());
ps.executeUpdate();