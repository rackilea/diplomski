String fieldName = "Text1";
PdfFormField field = form.getField(fieldName);

for (PdfAnnotation annotation : field.getWidgets()) {
    PdfPage page = annotation.getPage();
    Rectangle rectangle = annotation.getRectangle().toRectangle();

    Table table = new Table(UnitValue.createPointArray(new float[] {-1, -1}));
    table.setHorizontalAlignment(HorizontalAlignment.CENTER);
    Cell cell = new Cell();
    cell.add(new Paragraph("Name"));
    table.addCell(cell);
    cell = new Cell();
    cell.add(new Paragraph("Address"));
    table.addCell(cell);

    Canvas canvas = new Canvas(new PdfCanvas(page), pdfDocument, rectangle);
    canvas.add(table);
    canvas.close();

    page.removeAnnotation(annotation);
}