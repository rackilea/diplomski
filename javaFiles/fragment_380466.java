PdfReader reader = new PdfReader(SOURCE);
// step 1
Document document = new Document(PageSize.POSTCARD);
// step 2
PdfWriter writer
    = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
// step 3
document.open();
// step 4
PdfContentByte canvas = writer.getDirectContent();
PdfImportedPage page;
for (int i = 1; i <= reader.getNumberOfPages(); i++) {
    page = writer.getImportedPage(reader, i);
    canvas.addTemplate(page, 1f, 0, 0, 1, 0, 0);
}
// step 5
document.close();
reader.close();