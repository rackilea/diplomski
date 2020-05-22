String mongoURI = "mongodb://bdsandbox6:27017/test";
MongoDbConnection connection = null;
Map<String, Object> parameters = new HashMap<String, Object>();
try {
  connection = new MongoDbConnection(mongoURI, null, null);
  parameters.put(MongoDbDataSource.CONNECTION, connection);
  File jasperFile;
  jasperFile = new File("MongoDbReport.jasper");
  JasperCompileManager.compileReportToFile("MongoDbReport.jrxml", "MongoDbReport.jasper");
  JasperFillManager.fillReportToFile("MongoDbReport.jasper", parameters);
  JasperExportManager.exportReportToPdfFile("MongoDbReport.jrprint");
}
} catch (Exception e) {
  e.printStackTrace();
} finally {
  if (connection != null) {
    connection.close();
  }
}