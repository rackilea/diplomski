SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
configuration.setPrintPageBottomMargin(20);
configuration.setPrintPageBottomMargin(20);

JRXlsExporter exporterXLS = new JRXlsExporter();
...
exporterXLS.setConfiguration(configuration);
exporterXLS.exportReport();