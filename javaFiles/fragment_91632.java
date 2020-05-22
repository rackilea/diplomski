PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
Rectangle rect = new Rectangle(36, 700, 100, 100);
PdfFileSpec fs = PdfFileSpec.createEmbeddedFileSpec(pdfDoc,
    PATH, null, "test.csv", null, null, false);
PdfAnnotation attachment = new PdfFileAttachmentAnnotation(rect, fs)
            .setContents("Click me");
pdfDoc.addNewPage().addAnnotation(attachment);