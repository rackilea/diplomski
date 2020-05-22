JRPdfExporter exporter = new JRPdfExporter();             
exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrint));
exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//configuration.setConfigurations....;
exporter.setConfiguration(configuration);
exporter.exportReport();