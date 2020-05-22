public void createPdf(String file) throws IOException, DocumentException {
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
    // step 3
    document.open();
    // step 4
    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
            new FileInputStream(HTML));
    // step 5
    document.close();
}