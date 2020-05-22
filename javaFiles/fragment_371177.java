private void createPdf() throws Exception {
    Document doc = new Document();
    PdfSmartCopy copy = new PdfSmartCopy(doc, new FileOutputStream("result.pdf"));
    doc.open();

    PdfReader reader;
    PdfStamper stamper;
    AcroFields form;
    ByteArrayOutputStream baos;

    for(int i = 0; i < getTotalPages(); i++) {
        copyPdf(i);

        reader = new PdfReader(String.format("%d%s", i, "template.pdf"));
        baos = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, baos);
        form = stamper.getAcroFields();

        //methods to fill forms

        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
        copy.addPage(copy.getImportedPage(reader, 1));
    }

    doc.close();
}

private void copyPdf(int currentPage) throws Exception {
    PdfReader reader = new PdfReader("timesheet.pdf");
    Document doc = new Document();
    File file = new File(String.format("%d%s", currentPage, "template.pdf"));
    file.deleteOnExit();
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(file));
    stamper.close();
}