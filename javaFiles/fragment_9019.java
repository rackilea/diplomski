DatabaseMetaData meta = con.getMetaData();
  ResultSet res = meta.getTables(null, null, "My_Table_Name", 
     new String[] {"TABLE"});
  while (res.next()) {
     System.out.println(
        "   "+res.getString("TABLE_CAT") 
       + ", "+res.getString("TABLE_SCHEM")
       + ", "+res.getString("TABLE_NAME")
       + ", "+res.getString("TABLE_TYPE")
       + ", "+res.getString("REMARKS")); 
  }