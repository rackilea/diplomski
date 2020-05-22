PreparedStatement ps = con.prepareStatement("INSERT INTO Tiffany(Actor, Bio, More_Bio, Reason, Fact) VALUES (?, ?, ?, ?, ?) ");
ps.setString(1, Actor);
ps.setString(2, Bio);
ps.setString(3, More_Bio);
ps.setString(4, Reason);
ps.setString(5, Fact);
ps.executeUpdate();