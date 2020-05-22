try {
    //your code that is making and using jdbc is here

    //after you finish
    rs.close(); //if a ResultSet was returned
    stmt.close(); //Close Statement
    conn.close(); //Close Connection
}catch(SQLException se){
}catch(Exception e){
}finally{
    //finally block used to close resources if Closing failed above
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){
    }// nothing we can do
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
}//end try