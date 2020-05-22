public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
            stamper.getWriter(), null, "test.txt", "Some test".getBytes());
    stamper.addFileAttachment("some test file", fs);
    stamper.close();
}