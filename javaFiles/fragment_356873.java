public ResultSet select(String sql)
    {
         Statement  stmt = link.createStatement();
         rs = stmt.executeQuery(sql);                        
         return rs; 
    }