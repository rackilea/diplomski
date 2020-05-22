String jrxmlFileLocation = "D:\\OrderSet.jrxml";
String outputPDFFile = "D:\\VisitsSummaryReport.pdf";

// Compile your main report
JasperReport jasperReport = JasperCompileManager.compileReport(
      "D:\\Final_PatinetConsultation.jrxml");
// Compile your subReport report
JasperReport jasperSubReport = JasperCompileManager.compileReport(
      jrxmlFileLocation);
//Initialize parameters
Map parameters = new HashMap();
//Add subreport as parameter for main report
parameters.put("OrderSet", jasperSubReport); 
// Convert to JasperPrint - you may fill parameters here also if any
// and provide java.sql.Connection
JasperPrint document = JasperFillManager.fillReport(jasperReport, parameters, connection);
// Export to pdf 
JasperExportManager.exportReportToPdfFile(document, outputPdfFile);