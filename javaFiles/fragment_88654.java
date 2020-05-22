int id=12;
PreparedStatement ps=con.prepareStatement("select * from table where id=?");  
//You can set query parameters
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();     
while(rs.next()){  
//Get parameters 
int num=rs.getInt(1);  
}