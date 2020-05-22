//..
PreparedStatement ps = con.prepareStatement("INSERT INTO data_table VALUES(?, ?, ?)");
//...
ps.setInt(1,id);
ps.setString(2, file.getName());
ps.setBinaryStream(3, fs,fs.available());
int i = ps.executeUpdate();
//...