public Cursor getTestData(String whereClause)
 {;
     try
     {
         String sql ="SELECT * FROM tblPitanja WHERE 1 = 1 " + whereClause + " ORDER BY RANDOM() LIMIT 1";
         [...]