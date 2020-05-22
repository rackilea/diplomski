PdfPTable table = new PdfPTable(2);
PdfPCell cellOne = new PdfPCell(new Phrase("Hello"));
PdfPCell cellTwo = new PdfPCell(new Phrase("World"));

cellOne.setBorder(Rectangle.NO_BORDER);
cellOne.setBackgroundColor(new Color(255,255,45));

cellTwo.setBorder(Rectangle.BOX);

table.addCell(cellOne);
table.addCell(cellTwo);