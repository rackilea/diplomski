ps = con.prepareStatement(...);
//comment this line
// ResultSet r = ps.executeQuery();
ps.setString(1, "1");
//...
ResultSet result = ps.executeQuery();