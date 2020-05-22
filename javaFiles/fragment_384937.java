try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");   
  String sql = "select * from user;";
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery(sql);
  while (rs.next()) {
    val = rs.getString(2) + " " + rs.getString(3);
    value += val + " ";
  }
  JOptionPane.showMessageDialog(null,value);
}catch(SQLException e){
  JOptionPane.showMessageDialog(null, e);
}