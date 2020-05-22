public MyCellField(String fieldname) {
    this.fieldname = fieldname;
    this.color = BaseColor.BLACK;
}

 @Override
public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
    final PdfWriter writer = canvases[0].getPdfWriter();
    final TextField textField = new TextField(writer, rectangle, fieldname);
    textField.setAlignment(Element.ALIGN_CENTER);
    textField.setTextColor(color);
    textField.setFontSize(10);
    textField.setRotationFromPage(PageSize.A4.rotate());
try {
        final PdfFormField field = textField.getTextField();
        writer.addAnnotation(field);
    } catch (final IOException ioe) {
        throw new ExceptionConverter(ioe);
    } catch (final DocumentException de) {
        throw new ExceptionConverter(de);
    }
}