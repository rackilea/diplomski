JRExporter exporter = new HtmlExporter();

exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
SimpleHtmlExporterOutput output = new SimpleHtmlExporterOutput(out);
output.setImageHandler(new WebHtmlResourceHandler("/reports/image?image={0}"));
exporter.setExporterOutput(output);

exporter.exportReport();