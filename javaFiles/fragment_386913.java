protected Map<String, PdfFileSpecification> cache =
    new HashMap<String, PdfFileSpecification>();

public void cellLayout(final PdfPCell pdfPCell, final Rectangle rectangle, final PdfContentByte[] pdfContentBytes) {
    String hasheddata = createHash(attachment);
    PdfFileSpecification fs = cache.get(hasheddata);
    if (fs == null) {
        fs = PdfFileSpecification.fileEmbedded(writer, null, displayname, attachment);
        cache.put(hasheddata, fs);
    }
    PdfAnnotation an = PdfAnnotation.createFileAttachment(writer, rectangle, displayname, fs);
    writer.addAnnotation(an);
}