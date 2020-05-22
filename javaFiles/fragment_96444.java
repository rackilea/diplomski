//..
PreparedStatement ps = con.prepareStatement("INSERT INTO data_table VALUES(?, ?, ?)");
//...
byte[] content = new byte[fs.available()];
ps.setInt(1,id);
ps.setString(2, file.getName());
ps.setBytes(3, content);
int i = ps.executeUpdate();
//...