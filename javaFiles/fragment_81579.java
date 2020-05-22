String value1 = jTextField5.getText();
 String value2 = jTextField6.getText();
 String value3 = jTextField7.getText();
 String value4 = jTextField10.getText();
 String value5 = jTextField11.getText();
 String value6 = jTextField12.getText();
 String value7 = jTextField1.getText();
 String sql = "update Account  set  Nationality=? , Gender=? ,Address=? , Caste=? , Mob=? ,Sec_Q=?  where  Name =?"; 

pst=conn.prepareStatement(sql);
pst.setString(1, value1);
pst.setString(2, value2);
pst.setString(3, value3);
pst.setString(4, value4);
pst.setString(5, value5);
pst.setString(6, value6);
pst.setString(7, value7);
pst.execute( );

conn.commit(); //-->>>Don't forget the commit