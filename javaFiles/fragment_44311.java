PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
if(service != null) {
    DocFlavor docFlawor = DocFlavor.INPUT_STREAM.PDF;
    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();    
    DocPrintJob job = printService.createPrintJob();
    Doc pdf = new SimpleDoc(new URL(url).openStream(), docFlawor, null);
    job.print(pdf, printRequestAttributeSet);         
}