TXTFile file = mainApp.getFilesData().get(i);

PrintService service = PrintServiceLookup.lookupDefaultPrintService();

PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
pras.add(MediaSizeName.ISO_A4);

Doc doc = new SimpleDoc(new PrintableLog(file.getModifiedContent(), lineSeparator), DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
DocPrintJob job = service.createPrintJob();

PrintJobWatcher pjw = new PrintJobWatcher(job);
job.print(doc, pras);
pjw.waitForDone();