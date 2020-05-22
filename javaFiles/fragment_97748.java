PrinterJob printerJob = PrinterJob.createPrinterJob();
if (printerJob != null) {
  PageLayout pageLayout = printerJob.getPrinter().createPageLayout(Paper.A5, PageOrientation.LANDSCAPE, 0, 0, 0, 0);

  boolean success = printerJob.printPage(pageLayout, root);
  if (success) {
    printerJob.endJob();
  }
}