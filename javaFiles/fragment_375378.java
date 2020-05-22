JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath + "myReport.jasper", hm, con);

JRPdfExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE, outPath + outFile);
exporter.setParameter(JRPdfExporterParameter.METADATA_AUTHOR, "Adnan");
exporter.setParameter(JRPdfExporterParameter.METADATA_TITLE, "Title");
// ...
exporter.exportReport();