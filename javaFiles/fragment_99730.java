public void helloWorldForm() throws IOException {
    logger.info("create PDF on {}", DEST);

    final PdfWriter pdfWriter = new PdfWriter(DEST);
    final PdfDocument pdfDocument = new PdfDocument(pdfWriter);

    try (final Document document = new Document(pdfDocument)) {

        document.add(new Paragraph("Number with 2 decimal places"));

        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);
        PdfTextFormField nameField = PdfTextFormField.createText(pdfDocument,
                new Rectangle(99, 753, 425, 15), "value", "");
        form.addField(nameField);

        PdfAction validation = PdfAction.createJavaScript("AFNumber_Format(2,0,0,0,\"\", true);");
        nameField.setAdditionalAction(PdfName.F, validation);

        validation = PdfAction.createJavaScript("AFNumber_Keystroke(2,0,0,0,\"\", true);");
        nameField.setAdditionalAction(PdfName.K, validation);

    }

    pdfDocument.close();
}