public PdfDocument addBlankPage(final MediaModel pdfDocument) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (   InputStream inputStream = mediaService.getStreamFromMedia(pdfDocument);
            PdfReader reader = new PdfReader(inputStream);
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument document = new PdfDocument(reader, writer)) {
        document.addNewPage(document.getFirstPage().getPageSize());
    }
    return new PdfDocument(new PdfReader(new ByteArrayInputStream(baos.toByteArray())));
}