PreparedStatement ps20=null;
String filename=request.getParameter("my_file_element");
//if filename doesn't have anything in it just update doc_title if required
if(filename.equals("")){
  String sql1="update data_table set doc_title=? where doc_id='"+docId+"'";    
  ps20=con.prepareStatement(sql1);
  ps20.setString(1, documentTitle);
  int row1=ps20.executeUpdate();  
  if (row1 > 0) {
      msg= "Updated Successfully";
      System.out.println(msg);
    }      

}else{
   //if there exist filename
  String sql2="update data_table set doc_title=?,filename=? where doc_id='"+docId+"'";
  ps20=con.prepareStatement(sql2);
  ps20.setString(1, documentTitle);
  ps20.setString(2, filename);
  int row2=ps20.executeUpdate();
   if (row2 > 0) {
     msg= "Updated Successfully";
     System.out.println(msg);
      }    
 }