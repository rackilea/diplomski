List<tab_class> tabList = new ArrayList<>();
while(rs.next()){
   String col1 = rs.getString("col1");
   String col2 = rs.getString("col4");
   String col3 = rs.getString("col3");
   tabList.add(new tab_class( col1, col2, col3); // assuming you have this type of constructor
}