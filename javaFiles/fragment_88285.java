String name = userName.getText();
String[] names= name.split(" ");

pstmt = conn.prepareStatement("select * from table1, table2 where table1.fname=? and table1.lname=?");
pstmt.setString(1, names[0]);
pstmt.setString(2, names[1]);
 rs = pstmt.executeQuery();