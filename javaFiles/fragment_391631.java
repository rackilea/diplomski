public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    Map<String, String> info = reader.getInfo();
    info.put("Title", "Hello World stamped");
    info.put("Subject", "Hello World with changed metadata");
    info.put("Keywords", "iText in Action, PdfStamper");
    info.put("Creator", "Silly standalone example");
    info.put("Author", "Also Bruno Lowagie");
    stamper.setMoreInfo(info);
    stamper.close();
    reader.close();
}