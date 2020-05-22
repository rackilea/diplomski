Rectangle pageSize=new Rectangle(9400f,9400f);
Document doc=new Document(pageSize);

PdfWriter writer=PdfWriter.getInstance(document,baos);
writer.setUserunit(9900f);

// To prevent overlapping of columns, set the column widths as follows

PdfPTable table=new PdfPTable(120); // 120 is number of columns in table
table.setWidths(600f);