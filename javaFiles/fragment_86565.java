String query = "{call my_proc}";
try (CallableStatement stmt = conn.prepareCall(query)) {
    boolean results = stmt.execute();
    while (true) {
       if (results) {
           // results true means: result is ResultSet
           try (ResultSet rs = stmt.getResultSet()) {
               if(rs.next()) {
                   System.out.println(rs.getString("MSG"));
                   System.out.println(rs.getInt("SEQ"));
               }
           }
       } else {
           // results false means: result is update count
           // or no more results if updateCount is -1
           int updateCount = stmt.getUpdateCount();
           if (updateCount == -1) break;
           // Do something with update count
       }
       // Move to next result
       results = stmt.getMoreResults()
    }
 }