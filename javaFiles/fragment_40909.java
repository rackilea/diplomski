String updateSQL = "UPDATE student SET citizenship=?, degree=? WHERE sn=? ";
File os1 = new File(filenameImageCitizenShip); //load image as file
File os2 = new File(filenameImageDegree); //load image as file
FileInputStream inputOs1 = new FileInputStream(os1);
FileInputStream inputOs2 = new FIleInputStream(os2);
try{
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","");
    PreparedStatement pstmt = conn.prepareStatement(updateSQL);
    pstmt.setBinaryStream(1,os1);
    pstmt.setBinaryStream(2,os2); 
    pstmt.setBinaryStream(3,p);
    pstmt.executeUpdate();
  }catch(Exception e){
 }