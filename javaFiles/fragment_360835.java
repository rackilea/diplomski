Barcode128 code128 = new Barcode128();
code128.setBaseline(-1);
code128.setSize(12);
code128.setCode(code);
code128.setCodeType(Barcode128.CODE128);
Image code128Image = code128.createImageWithBarcode(cb, null, null);
PdfPCell cell = new PdfPCell(code128Image);
table.addCell(cell);