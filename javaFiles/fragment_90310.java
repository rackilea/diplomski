PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
PrintService service = ServiceUI.printDialog(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(), 200, 200,
                      printService, defaultService, flavor, pras);
if (service != null) {
    DocPrintJob job = service.createPrintJob();
    FileInputStream fis = new FileInputStream(doc);
    DocAttributeSet das = new HashDocAttributeSet();
    Doc document = new SimpleDoc(fis, flavor, das);
    job.print(document, pras);
}