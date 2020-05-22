PreparedStatement ps = con.prepareStatement("insert into students values(?,?,?,?,?)");
ps.setString(1,name);
ps.setString(2,regno);
ps.setInt(3,m1);
ps.setInt(4,m1);
ps.setInt(5,m3);
int nupdate = ps.executeUpdate();