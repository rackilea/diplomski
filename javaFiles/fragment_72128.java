PdfReader insert = new PdfReader(INSERT);
PdfReader reader = new PdfReader(src);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST));
stamper.insertPage(4, insert.getPageSize(1));
PdfContentByte cb = stamper.getOverContent(4);
cb.addTemplate(stamper.getImportedPage(insert, 1), 0, 0);
...
stamper.close();