Connection con = null;
try {
     con = DatabaseUtil.getConnection();
    ...
    ...
}catch(Exception e) {
   //show message, dialog box, whatever
} finally {
   if(con != null) {
         try{
            con.close();
         }catch(SQLException sqe){
              //yet another message, unable to close connection cleanly.
         }
   }
}