PdfPTable table = new PdfPTable(1);

PdfPTable table1 = new PdfPTable(3);

table1.setWidthPercentage(100f);
table1.addCell("cell A0");
table1.addCell("cell A1");
table1.addCell("cell A2");

PdfPTable table2 = new PdfPTable(2);

table2.setWidthPercentage(100f);
table2.addCell("cell B0");
table2.addCell("cell B1");

table.addCell(table1);
table.addCell(table2);