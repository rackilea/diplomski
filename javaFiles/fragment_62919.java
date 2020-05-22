JRExporter exporter = new HtmlExporter();
// output file for generated html report
File file = new File(String.format("./out/%1$s_%2$s.html", report.getTemplateName(), new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));

ExporterConfiguration configuration = new SimpleHtmlExporterConfiguration();
exporter.setConfiguration(configuration);

exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
SimpleHtmlExporterOutput exporterOutput = new SimpleHtmlExporterOutput(file);
// the folder for storing images. It will be subfolder with name starting like generated html and ended with postfix "_images"
File resourcesDir = new File(file.getParent(), file.getName() + "_images");
// argument ({0}) will be replaced with the real image name
String pathPattern = resourcesDir.getName() + "/{0}";

exporterOutput.setImageHandler(new FileHtmlResourceHandler(resourcesDir, pathPattern));
exporter.setExporterOutput(exporterOutput);
exporter.exportReport();