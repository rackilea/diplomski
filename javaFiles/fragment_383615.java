PdfReader reader = new PdfReader(src);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
PdfContentByte canvas = stamper.getOverContent(1);
PdfPTable table = ...;
//add data to table
table.writeSelectedRows(... , canvas);
stamper.close();
reader.close();