try{
   //the insert method is here
}catch(SQLException e){
  e.printStackTrace();
}finally{
  if(st != null){
    st.close();
  }
  if(rs != null){
   rs.close();
  }

}