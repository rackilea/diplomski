String query = "SELECT * FROM CUSTOMERS WHERE CUSTID=?";
// ResultSet rs = pstmt.executeQuery( query );
pstmt = c.prepareStatement(query);
pstmt.setInt(1, CustID);
rs = pstmt.executeQuery();
// c.commit();