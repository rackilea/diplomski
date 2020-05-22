public void createPdf(String filename) throws IOException, DocumentException {
    PdfReader[] readers = {
        new PdfReader(getFile1()),
        new PdfReader(getFile2())
    };
    createPdf(filename, readers);
}

public void createPdf(String filename, PdfReader[] readers)
    throws IOException, DocumentException {
    Document document = new Document();
    PdfCopy copy = new PdfCopy(document, new FileOutputStream(filename));
    copy.setMergeFields();
    document.open();
    for (PdfReader reader : readers) {
        copy.addDocument(reader);
    }
    document.close();
    for (PdfReader reader : readers) {
        reader.close();
    }
}