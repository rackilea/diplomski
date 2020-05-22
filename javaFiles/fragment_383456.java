private PdfPCell createMinHeight(float minH) {
    PdfPCell cell = new PdfPCell();
    PdfPTable table = new PdfPTable(1);
    cell.setBorder(Rectangle.NO_BORDER);
    table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
    table.setHeaderRows(0);
    PdfPCell firstRow = new PdfPCell();
    firstRow.setBorder(Rectangle.NO_BORDER);
    firstRow.setMinimumHeight(minH);
    firstRow.setPadding(0);
    table.addCell(firstRow);
    table.addCell("");
    cell.setPadding(0);
    cell.addElement(table);
    return cell;
}