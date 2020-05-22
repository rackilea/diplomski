PdfReader reader = new PdfReader(inFilename);
int n = reader.getNumberOfPages();
if (n > 1) {
    Document doc = new Document();
    PdfCopy copy= new PdfCopy(doc, new FileOutputStream(outFilename));
    doc.open();
    PdfImportedPage page = copy.getImportedPage(reader, 1);
    copy.addPage(page);
    doc.close();
}
reader.close();