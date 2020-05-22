String exportText = getString("val_table_create.sql");
for (Sheet sheet : bookSheets) {
    setHeader(table, sheet);        
    String newExportText = exportText.replaceAll(TABLE_NAME, tableName);
  messageDataType);
    exportFile(newExportText, absoluteWorkspacePath + File.separator + outputPath + File.separator, tableName, ".sql");
}