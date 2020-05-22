//when inserting into CUSTOMER 
pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
pstmt.execute();//make the insert
//and then simply grab the key
ResultSet rs = stmt.getGeneratedKeys();
if (rs.next()) 
id = rs.getObject(1);