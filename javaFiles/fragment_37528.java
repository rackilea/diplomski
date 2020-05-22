ByteArrayOutputStream os = new ByteArrayOutputStream();
Document bigDoc = new Document(PageSize.LETTER, 50, 50, 110, 60);
PdfWriter writer = PdfWriter.getInstance(bigDoc, os);
bigDoc.open();
Paragraph par = new Paragraph("one");
bigDoc.add(par);
bigDoc.add(new Paragraph("three"));
bigDoc.close();

ByteArrayOutputStream os2 = new ByteArrayOutputStream();
Document finalDoc = new Document();
PdfCopy copy = new PdfCopy(finalDoc, new FileOutputStream(RESULT2));
finalDoc.open();
PdfReader reader = new PdfReader(os.toByteArray());
for (int i = 0; i < reader.getNumberOfPages();) {
    copy.addPage(copy.getImportedPage(reader, ++i));
}
PdfReader pdfReader = new PdfReader("c:/insertable.pdf");
copy.addPage(copy.getImportedPage(pdfReader, 1));
finalDoc.close();
reader.close();
pdfReader.close();

// result PDF
byte[] result = os2.toByteArray();