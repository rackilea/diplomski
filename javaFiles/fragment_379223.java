public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    Rectangle rect = new Rectangle(36, 700, 136, 800);
    PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
            writer, PATH, "test.docx", null);
    PdfAnnotation attachment =
            PdfAnnotation.createFileAttachment(writer, rect, "Click me" , fs);
    PdfAppearance app = writer.getDirectContent().createAppearance(100, 100);
    Image img = Image.getInstance(IMG);
    img.scaleAbsolute(100, 100);
    img.setAbsolutePosition(0, 0);
    app.addImage(img);
    attachment.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, app);
    writer.addAnnotation(attachment);
    document.close();
}