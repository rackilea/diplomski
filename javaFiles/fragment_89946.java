BaseFont bf = BaseFont.createFont(
    "c://windows/fonts/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
Font font = new Font(bf, 8);
PdfPTable table = new PdfPTable(1);
PdfPCell  cell = new PdfPCell(new Phrase("\u062D\u064A\u0633\u0648", font));
cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
table.addCell(cell);
document.add(table);