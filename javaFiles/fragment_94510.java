PdfCleanUpLocation dummyLocation = new PdfCleanUpLocation(1, new Rectangle(0, 0, 0, 0), null);
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(input), new PdfWriter(output));

    PdfCleanUpTool cleaner = (cleanUpLocations == null)
            ? new PdfCleanUpTool(pdfDocument, true)
            : new PdfCleanUpTool(pdfDocument, cleanUpLocations);
    cleaner.cleanUp();

    pdfDocument.close();