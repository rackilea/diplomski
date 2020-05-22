public void createPdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
                        PdfWriter.AllowPrinting, PdfWriter.STRENGTH128BITS);
    stamper.close();
}