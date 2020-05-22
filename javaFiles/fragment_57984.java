PreparedStatement ps=con.prepareStatement("insert into imgtable values(?)");
FileInputStream fin=new FileInputStream(fileFromChooser);  
ps.setBinaryStream(1,fin,fin.available());  

int i=ps.executeUpdate();  
System.out.println(i+" records affected");