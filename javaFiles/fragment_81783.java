JasperPrint jasperPrint1 = JasperFillManager.fillReport(reportStream1,  parameters, conn);
JasperPrint jasperPrint2 = JasperFillManager.fillReport(reportStream2,  parameters, conn);

List<JasperPrint> list = new ArrayList<JasperPrint>();
list.add(jasperPrint1);
list.add(jasperPrint2);

JRPdfExporter exporter = new JRPdfExporter();

exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, list);
exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM,servletOutputStream); 
exporter.exportReport();