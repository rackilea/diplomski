public String rawprint(String printerName, String conte) {
    String res = "";
    PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
    printServiceAttributeSet.add(new PrinterName(printerName, null));
    PrintService printServices[] = PrintServiceLookup.lookupPrintServices(null, printServiceAttributeSet);
    if (printServices.length != 1) {
        return "Can't  select printer :" + printerName;
    }
    byte[] printdata = conte.getBytes();
    PrintService pservice = printServices[0];
    DocPrintJob job = pservice.createPrintJob();
    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
    Doc doc = new SimpleDoc(printdata, flavor, null);
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    try {
        job.print(doc, aset);
    } catch(Exception e){
        res = e.getMessage();

    }
    return res;
}