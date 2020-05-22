public void addAttachments(
  String src, String dest, String[] attachments) throws IOException, DocumentException {
  PdfReader reader = new PdfReader(src);
  PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
  for (int i = 0; i < attachments.length; i++) {
    addAttachment(stamper.getWriter(), new File(attachments[i]));
  }
  stamper.close();
}

protected void addAttachment(PdfWriter writer, File src) throws IOException {
  PdfFileSpecification fs =
    PdfFileSpecification.fileEmbedded(writer, src.getAbsolutePath(), src.getName(), null);
  writer.addFileAttachment(src.getName().substring(0, src.getName().indexOf('.')), fs);
}