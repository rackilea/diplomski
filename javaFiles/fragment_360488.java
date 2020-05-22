ResultSetMetaData md = rs.getMetaData(); 
int colCount = md.getColumnCount();  

for (int i = 1; i <= colCount ; i++){  
String col_name = md.getColumnName(i);  
System.out.println(col_name);  
}