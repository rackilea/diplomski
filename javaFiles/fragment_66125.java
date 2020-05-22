PdfPTable table = new PdfPTable(4) // 4 Columns
PdfPCell cell;
cell = new PdfPCell( new Phrase("Cell with colspan of 4") ) ;
cell. setColspan(4) ; // an entire row

anotherCell = new PdfPCell( new Phrase("Cell with colspan of 4") );
anotherCell.setColspan(4); // a second row