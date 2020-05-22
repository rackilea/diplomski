PreparedStatement pstmt = con.prepareStatement("UPDATE PRODUCTS SET IMAGE = ? WHERE ID = ?");
File file = new File("C:\\Program Files (x86)\\openbravopos-2.30.2\\image.jpg");
FileInputStream in = new FileInputStream(file);
try
{
    pstmt.setBinaryStream(1, in, (int) file.length());
    pstmt.setString(2, id);
    pstmt.executeUpdate();
    //con.commit
}
catch (Exception ee)
{
    System.out.println("Exception is:- " + ee);
}