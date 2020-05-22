public void print() throws PrintException, IOException {
    String defaultPrinter =
            PrintServiceLookup.lookupDefaultPrintService().getName();
    System.out.println("Default printer: " + defaultPrinter);
    PrintService service = PrintServiceLookup.lookupDefaultPrintService();

    InputStream is = new ByteArrayInputStream(printableAmounts.getBytes("UTF8"));

    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    pras.add(new Copies(1));

    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
    Doc doc = new SimpleDoc(is, flavor, null);
    DocPrintJob job = service.createPrintJob();

    PrintJobWatcher pjw = new PrintJobWatcher(job);
    job.print(doc, pras);
    pjw.waitForDone();
    is.close();
}