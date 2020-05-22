Connection con = db.getConnection();
    DatabaseMetaData metaData = con.getMetaData();

    String tableType[] = {"TABLE"};    

   ResultSet result = metaData.getTables(null,SCHEMA_NAME,null,tableType);
 while(result.next())
    {
     String tableName = result.getString(3);
     System.out.println(tableName)
}