try (Connection conn = connectionProvider.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql);) {

     for (int i = 0; i < kvs.length; i++) {
         setPrepareStatementParameter(pstmt, kvs[i]);

         // do other stuff

         // Place the ResultSet in another try with resources
         // to ensure the previous iteration's ResultSet
         // is closed when the next iteration begins
         try (ResultSet res = pstmt.executeQuery()) {
             ..............

         }
     }
 }