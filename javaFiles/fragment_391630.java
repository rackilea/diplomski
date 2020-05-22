public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.addTitle("Some example");
    document.add(new Header("Test", "test"));
    document.open();
    Paragraph p = new Paragraph("Hello World");
    document.add(p);
    document.close();
}