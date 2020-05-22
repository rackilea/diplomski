Document document = new Document();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PdfWriter writer = PdfWriter.getInstance(document, baos);
document.open();
document.add(new Paragraph("Hello World!"));
document.close();
ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
PDDocument document = PDDocument.load(bais);