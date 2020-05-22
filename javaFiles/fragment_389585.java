Document document = new Document();
PdfCopy copy = new PdfCopy(document, new FileOutputStream(dest));
document.open();
PdfReader reader;
for (String path : paths) {
    reader = new PdfReader(path);
    copy.addPage(copy.getImportedPage(reader, 1));
    reader.close();
}
reader = new PdfReader("resources/main_document.pdf");
copy.addDocument(reader);
reader.close();
document.close();