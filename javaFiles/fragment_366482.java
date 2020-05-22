File image=new file("'C:\Project\images\image.jpg");
String Sql="insert into Account_images(img_id,img_id,icon) values(1,1,?)";
PreparedStatement pStatement=connection.prepareStatement(sql);
FileInputStream   fis =fis = new FileInputStream(image);
pStatement.setBinaryStream(1, fis,fis.length());
ResultSet result=pStatement.executeUpdate();