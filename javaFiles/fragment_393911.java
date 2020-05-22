Paragraph paragraph=new Paragraph("Test in the Cell");

paragraph.getFont().setStyle(Font.BOLD);

Cell c=new Cell(paragraph);

table.addCell(c);