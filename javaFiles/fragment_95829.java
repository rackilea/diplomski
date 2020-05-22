public static void main(String[] args) {
    try
    {
        FileInputStream fis = new FileInputStream("c:\\N0018902726.pdf");
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        DocAttributeSet das = new HashDocAttributeSet(); 
        Doc pdfDoc = new SimpleDoc(fis, flavor, null);
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService(); 
        DocPrintJob printJob = printService.createPrintJob();
        printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
        fis.close();
    }
    catch (Exception e) {
        System.out.println("EXCEPTIOn : " +e.getMessage());

    }
}