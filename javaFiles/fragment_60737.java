PreparedStatement pst = connection.prepareStatement(sql);
pst.setInt(1, agentid);
pst.setInt(2, birthyear);
pst.setString(3, familyname);
pst.setString(4, givenname);

// add this line
pst.executeUpdate();