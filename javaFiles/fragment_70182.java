// Schema is : create table my_table (col1 char(10));
//             insert into my_table values ('JDBC');
PreparedStatement pstmt = conn.prepareStatement
("select count() from my_table where col1 = ?");
ResultSet rs;

pstmt.setString (1, "JDBC");  // Set the Bind Value
rs = pstmt.executeQuery();    // This does not match any row
// ... do something with rs
CHAR ch = new CHAR("JDBC      ", null);
((OraclePreparedStatement)pstmt).setCHAR(1, ch); // Pad it to 10 bytes
rs = pstmt.executeQuery();     // This matches one row
// ... do something with rs
((OraclePreparedStatement)pstmt).setFixedCHAR(1, "JDBC");
rs = pstmt.executeQuery();     // This matches one row
// ... do something with rs