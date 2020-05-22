public static void main(String[] args) throws Exception {
    // RadioButton with cross instead of bullet.
    final String filename = "SampleRadioButton.pdf";
    final float boxLength = 20;
    final float crossWidth = 1;
    final String[] languages = { "Dutch", "English", "French" };
    try (PdfWriter writer = new PdfWriter(filename); PdfDocument pdfDoc = new PdfDocument(writer); Document doc = new Document(pdfDoc)) {
        pdfDoc.addNewPage();
        final PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        final PdfButtonFormField radioGroup = PdfFormField.createRadioGroup(pdfDoc, "Language", languages[1]);
        int count = 0;
        for (final String language : languages) {
            count++;
            // button
            final Rectangle rect = new Rectangle(40, 800 - (count * 30), boxLength, boxLength);
            final PdfFormField radioButton = PdfFormField.createRadioButton(pdfDoc, rect, radioGroup, language);
            final PdfDictionary radioDict = radioButton.getPdfObject();
            final PdfDictionary mk = new PdfDictionary();
            mk.put(PdfName.CA, new PdfString("8")); // check=4, circle=1, cross=8, diamond=u, square=n, star=H
            radioDict.put(PdfName.MK, mk);
            radioButton.setVisibility(PdfFormField.VISIBLE);
            editAppearance(pdfDoc, radioButton, language, boxLength, crossWidth);
            // text
            final Paragraph para = new Paragraph(language).setFontSize(18);
            doc.showTextAligned(para, 70, 800 - (count * 30), TextAlignment.LEFT);
        }
        form.addField(radioGroup);
    }
    Desktop.getDesktop().open(new File(filename));
}

private static void editAppearance(PdfDocument pdfDoc, PdfFormField radioButton, String value, float length, float crossWidth) {
    final PdfStream streamOn = (PdfStream) new PdfStream().makeIndirect(pdfDoc);
    final PdfCanvas canvasOn = new PdfCanvas(streamOn, new PdfResources(), pdfDoc);
    final Rectangle rect = new Rectangle(0, 0, length, length);
    final PdfFormXObject xObjectOn = new PdfFormXObject(rect);
    canvasOn.saveState();
    canvasOn.setStrokeColor(ColorConstants.BLACK).setLineWidth(crossWidth);
    // bottom left to top right
    canvasOn.moveTo(0, 0).lineTo(length, length).stroke();
    // Top left to bottom right
    canvasOn.moveTo(0, length).lineTo(length, 0).stroke();
    canvasOn.restoreState();
    xObjectOn.getPdfObject().getOutputStream().writeBytes(streamOn.getBytes());
    final PdfWidgetAnnotation widget = radioButton.getWidgets().get(0);
    widget.setNormalAppearance(new PdfDictionary());
    widget.getNormalAppearanceObject().put(new PdfName(value), xObjectOn.getPdfObject());
}