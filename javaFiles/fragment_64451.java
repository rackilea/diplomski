PdfPTable table = new PdfPTable(3);

table.addCell("cell A0");
table.addCell("cell A1");
table.addCell("cell A2");
table.addCell("cell B0");
table.addCell("cell B1");
table.addCell("cell B2");

PdfPCell cell = new PdfPCell();
cell.setColspan(2);
cell.addElement(new Phrase("C0 & C1"));

table.addCell(cell);

table.addCell("cell C2");