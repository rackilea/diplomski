public PdfDocument addBlankPage(final MediaModel pdfDocument) throws IOException {
    try (   InputStream inputStream = mediaService.getStreamFromMedia(pdfDocument);
            PdfReader reader = new PdfReader(inputStream);
            PdfWriter writer = new PdfWriter(pdfDocument.getRealFileName());
            PdfDocument document = new PdfDocument(reader, writer)) {
        document.addNewPage(document.getFirstPage().getPageSize());
    }
    return new PdfDocument(new PdfReader(pdfDocument.getRealFileName()));
}