Date d=new Date();
java.sql.Date  d1=new java.sql.Date(d.getTime());
String sql = "INSERT INTO info (date) VALUES ( ? )";

try {
      pstmt = con.prepareStatement(sql);
       pstmt.setDate(1, d1); 
      pstmt.executeUpdate();
     } catch (SQLException e) {
            System.out.println("Error:" + e);
     }