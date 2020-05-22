ByteArrayOutputStream os = new ByteArrayOutputStream();
Document bigDoc = new Document(PageSize.LETTER, 50, 50, 110, 60);
PdfWriter writer = PdfWriter.getInstance(bigDoc, os);
bigDoc.open();
Paragraph par = new Paragraph("one");
bigDoc.add(par);
bigDoc.add(new Paragraph("three"));

PdfReader pdfReader = new PdfReader("c:/insertable.pdf");
PdfImportedPage page = writer.getImportedPage(pdfReader, 1);
bigDoc.newPage();
PdfContentByte canvas = writer.getDirectContent();
canvas.addTemplate(page, 1, 0, 0, 1, 0, 0);

bigDoc.close();
pdfReader.close();

// result PDF
byte[] result = os.toByteArray();