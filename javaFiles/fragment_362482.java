String sql2 = "INSERT INTO table1(id, name) VALUES (?, ?)"; 
ps.setInt(1, nextID_from_seq); 
ps.setString(2, "tar");
ps.executeUpdate();     
sql2 = "INSERT INTO table2(id, name) VALUES (?, ?)";
ps.setInt(1, nextID_from_seq); 
ps.setString(2, "par");
ps.executeUpdate();
...
...