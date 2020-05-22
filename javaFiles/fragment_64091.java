Connection connection=null;
PreparedStatement statement=null;
String sql="UPDATE TableName set ImageCol1=? WHERE ID=?";
try{
  //Obtain connection 
  statement=connection.prepareStatement(sql);
  statement.setBytes(1,byteArray);
  statement.setInt(2,10);
  ...
}catch(SQLException ex){
  //
}finally{
  if(ps!=null) {
    try{
      ps.close();
    }catch(Exception ex){
      //
    }
  }
 if(cn!=null) {
    try{
      cn.close();
    }catch(Exception ex){
      //
    }
  }
}