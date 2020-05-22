try {

    String report = JasperCompileManager.compileReportToFile(sourceFileName);

    JasperPrint jasperPrint = JasperFillManager.fillReport(report, para, ds);

    PrinterJob printerJob = PrinterJob.getPrinterJob();

    PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
    printerJob.defaultPage(pageFormat);

    int selectedService = 0;

    AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName(printerNameShort, null));

    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);

    try {
        printerJob.setPrintService(printService[selectedService]);

    } catch (Exception e) {

        System.out.println(e);
    }
    JRPrintServiceExporter exporter;
    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
    printRequestAttributeSet.add(MediaSizeName.NA_LETTER);
    printRequestAttributeSet.add(new Copies(1));

    // these are deprecated
    exporter = new JRPrintServiceExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
    exporter.exportReport();

} catch (JRException e) {
    e.printStackTrace();
}