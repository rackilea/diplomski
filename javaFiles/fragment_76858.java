PdfReader reader = new PdfReader(MovieTemplates.RESULT);
int n = reader.getNumberOfPages();
PdfImportedPage page;
PdfPTable table = new PdfPTable(2);
for (int i = 1; i <= n; i++) {
    page = writer.getImportedPage(reader, i);
    table.getDefaultCell().setRotation(-page.getRotation());
    table.addCell(Image.getInstance(page));
}
document.add(table);