int index = 1;
String sql = "INSERT INTO Student(name,famillyname,email,password,module,speciality,card,id_goupe)" + 
    "VALUES(?,?,?,?,?,?,?,(SELECT MAX(id) FROM goupe));";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setString(index++, name);
ps.setString(index++, familyname);
ps.setString(index++, email);
ps.setString(index++, password);
ps.setString(index++, module);
ps.setString(index++, speciality);
ps.setString(index++, card);
int rows = ps.executeUpdate();
if(rows == 1) {
    System.out.println("Successfully inserted row");
}