Connection conn = null;
PreparedStatement pstmt = null;

conn = getConnection();
String query = "select * from table_name between ? and ?";
pstmt = conn.prepareStatement(query);
pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
pstmt.setDate(2, new java.sql.Date(endDate.getTime()));

ResultSet resultSet = pstmt.executeQuery();