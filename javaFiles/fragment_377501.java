tab_class tbcl = new tab_class();
while(rs.next()){
   tbcl.col1 = rs.getString("col1");
   tbcl.col2 = rs.getString("col4");
   tbcl.col3 = rs.getString("col3");
}