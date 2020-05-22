public static final String[] ATTACHMENTS = {
    "hello", "world", "what", "is", "up"
};
public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    for (String s : ATTACHMENTS) {
        PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
            stamper.getWriter(), null, String.format("%s.txt", s),
            String.format("Some test: %s", s).getBytes());
        stamper.addFileAttachment(String.format("Content: %s", s), fs);
    }
    stamper.close();
}