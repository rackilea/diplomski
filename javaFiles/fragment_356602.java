File image = new File(path);
FileInputStream fis = new FileInputStream ( image );

String sql="insert into imgtst (username,image) values (?, ?)";
pst=con.prepareStatement(sql);

pst.setString(1, user);
pst.setBinaryStream (2, fis, (int) file.length() );