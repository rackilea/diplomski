String tableNamePattern = "customer";
DatabaseMetaData databaseMetaData = conn.getMetaData();

ResultSet columns = 
       databaseMetaData.getColumns(null, null, tableNamePattern, null);

ResultSet primaryKeys = 
       databaseMetaData.getPrimaryKeys(null, null, tableNamePattern);

ResultSet indexInfo = 
       databaseMetaData.getIndexInfo(null, null, tableNamePattern, false, false);