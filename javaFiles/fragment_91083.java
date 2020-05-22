public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
        stamper.getWriter(), null, "test.txt", "Some test".getBytes());
    Rectangle rect = new Rectangle(36, 770, 72, 806);
    PdfAnnotation attachment = dfAnnotation.createFileAttachment(
        stamper.getWriter(), rect, "My attachment", fs);
    stamper.addAnnotation(attachment, 1);
    stamper.close();
}