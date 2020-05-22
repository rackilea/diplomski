JRXlsExporter exporter = new JRXlsExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(destFile));
SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
configuration.setOnePagePerSheet(true);
configuration.setDetectCellType(true);
configuration.setCollapseRowSpan(false);
exporter.setConfiguration(configuration);

exporter.exportReport();