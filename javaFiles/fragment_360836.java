code128 = new Barcode128();
code128.setFont(null);
code128.setCode(code);
code128.setCodeType(Barcode128.CODE128);
code128Image = code128.createImageWithBarcode(cb, null, null);
cell = new PdfPCell();
cell.addElement(new Phrase("PO #: " + code));
cell.addElement(code128Image);
table.addCell(cell);