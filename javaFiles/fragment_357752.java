// Define a pdf exporter
PdfExport pdfExport = new pdfExport();
Application app = new Application();
// Register the new exporter
app.addExporter(pdfExport);
// Export some data...
app.export(information);