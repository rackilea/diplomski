String query = "SELECT * FROM Product where <column> LIKE ?";
query = query.replaceAll("<column>", col);

PreparedStatement ps = con.prepareStatement(query);
ps.setString(1, prod);
ResultSet rs = ps.executeQuery();