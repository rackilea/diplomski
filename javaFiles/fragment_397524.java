PreparedStatement pre = Con0.prepareStatement("select id from mytable where x=?");

for (int i=0; i< num_rows ; i++) {
   pre.setString(1, y.get(i));
   ResultSet rs2 = pre.executeQuery();
   ... // process result in rs2
   rs2.close(); 
   pre.clearParameters();
}
pre.close();