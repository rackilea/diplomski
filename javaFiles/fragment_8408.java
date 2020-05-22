int size= 0;
if (rs != null)   
{  
  rs.beforeFirst();  
  rs.last();  
  size = rs.getRow();  
}