public void moveCleanSection(PdfReader pdfReader, String targetFile, int page, Rectangle from, Rectangle to) throws IOException
{
    LicenseKey.loadLicenseFile("itextkey-multiple-products.xml");

    ByteArrayOutputStream interimMain = new ByteArrayOutputStream();
    ByteArrayOutputStream interimPage = new ByteArrayOutputStream();
    ByteArrayOutputStream interimSection = new ByteArrayOutputStream();

    try (   PdfDocument pdfMainDocument = new PdfDocument(pdfReader);
            PdfDocument pdfPageDocument = new PdfDocument(new PdfWriter(interimPage)) )
    {
        pdfMainDocument.setCloseReader(false);
        pdfMainDocument.copyPagesTo(page, page, pdfPageDocument);
    }

    try (   PdfDocument pdfMainDocument = new PdfDocument(pdfReader, new PdfWriter(interimMain));
            PdfDocument pdfSectionDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(interimPage.toByteArray())), 
            new PdfWriter(interimSection))  )
    {

        List<PdfCleanUpLocation> cleanUpLocations = new ArrayList<PdfCleanUpLocation>();
        cleanUpLocations.add(new PdfCleanUpLocation(page, from, null));
        cleanUpLocations.add(new PdfCleanUpLocation(page, to, null));

        PdfCleanUpTool cleaner = new PdfCleanUpTool(pdfMainDocument, cleanUpLocations);
        cleaner.cleanUp();

        cleanUpLocations = new ArrayList<PdfCleanUpLocation>();
        Rectangle mediaBox = pdfSectionDocument.getPage(1).getMediaBox();

        if (from.getTop() < mediaBox.getTop())
            cleanUpLocations.add(new PdfCleanUpLocation(1, new Rectangle(mediaBox.getLeft(), from.getTop(), mediaBox.getWidth(), mediaBox.getTop() - from.getTop()), null));
        if (from.getBottom() > mediaBox.getBottom())
            cleanUpLocations.add(new PdfCleanUpLocation(1, new Rectangle(mediaBox.getLeft(), mediaBox.getBottom(), mediaBox.getWidth(), from.getBottom() -  mediaBox.getBottom()), null));
        if (from.getLeft() > mediaBox.getLeft())
            cleanUpLocations.add(new PdfCleanUpLocation(1, new Rectangle(mediaBox.getLeft(), mediaBox.getBottom(), from.getLeft() - mediaBox.getLeft(), mediaBox.getHeight()), null));
        if (from.getRight() < mediaBox.getRight())
            cleanUpLocations.add(new PdfCleanUpLocation(1, new Rectangle(from.getRight(), mediaBox.getBottom(), mediaBox.getRight() - from.getRight(), mediaBox.getHeight()), null));

        cleaner = new PdfCleanUpTool(pdfSectionDocument, cleanUpLocations);
        cleaner.cleanUp();
    }

    try (   PdfDocument pdfSectionDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(interimSection.toByteArray())));
            PdfDocument pdfMainDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(interimMain.toByteArray())), new PdfWriter(targetFile)) )
    {
        float scale = Math.min(to.getHeight() / from.getHeight(), to.getWidth() / from.getWidth());
        pdfSectionDocument.getPage(1).setMediaBox(from);
        PdfFormXObject pageXObject = pdfSectionDocument.getFirstPage().copyAsFormXObject(pdfMainDocument);
        PdfPage pdfPage = pdfMainDocument.getPage(page);
        PdfCanvas pdfCanvas = new PdfCanvas(pdfPage);
        pdfCanvas.addXObject(pageXObject, scale, 0, 0, scale, (to.getLeft() - from.getLeft() * scale), (to.getBottom() - from.getBottom() * scale));
    }
}