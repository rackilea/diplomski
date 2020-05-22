private static final void executeBulkLoad(
                    Connection connection, 
                    String schema,
                    String tableName,
                    File file,
                    String filename,
                    String encoding) throws SQLException   {

            String filePath = file.getAbsolutePath();
            String logFolderPath = filePath.replace(filename, "");

            String SQLString  = "INSERT INTO " + schema + "." + tableName + "\n";
            SQLString += "SELECT * FROM\n"; 
            SQLString += "EXTERNAL '" + filePath + "'\n";
            SQLString += "USING\n";
            SQLString += "(\n";
            SQLString += "    ENCODING '" + encoding + "'\n";
            SQLString += "    QUOTEDVALUE 'NO'\n";
            SQLString += "    FILLRECORD 'TRUE'\n";
            SQLString += "    NULLVALUE 'NULL'\n";
            SQLString += "    SKIPROWS 1\n";
            SQLString += "    DELIMITER '\\t'\n";
            SQLString += "    LOGDIR '" + logFolderPath + "'\n";
            SQLString += "    REMOTESOURCE 'JDBC'\n";
            SQLString += "    CTRLCHARS 'TRUE'\n";
            SQLString += "    IGNOREZERO 'TRUE'\n";
            SQLString += "    ESCAPECHAR '\\'\n";
            SQLString += ");";

            Statement statement = connection.createStatement();
            statement.execute(SQLString);
            statement.close();
    }