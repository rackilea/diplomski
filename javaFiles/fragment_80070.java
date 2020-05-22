PdfPCell cell;
PdfPTable table = new PdfPTable(3);

cell = new PdfPCell(new Phrase("Item Name"));
cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_LEFT);
cell.setBorder(Rectangle.NO_BORDER);
table.addCell(cell);

cell = new PdfPCell(new Phrase("Quantità"));
cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_CENTER);
cell.setBorder(Rectangle.NO_BORDER);
table.addCell(cell);

cell = new PdfPCell(new Phrase("€"));
cell.setHorizontalAlignment(com.lowagie.text.Element.ALIGN_RIGHT);
cell.setBorder(Rectangle.NO_BORDER);
table.addCell(cell);
table.setHeaderRows(1);

for (int i=1;i<5;i++) {
    // we add a cell with colspan 3
    cell = new PdfPCell(new Phrase("Name:" + i));
    cell.setColspan(3);
    cell.setBorder(Rectangle.NO_BORDER);
    table.addCell(cell);
}