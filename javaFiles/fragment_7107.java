PdfReader reader = null;
PdfCopy copier = new PdfCopy(outputStream);
String paths[] = ...;
for (String path : paths) {
  reader = new PdfReader(path);
  for (int pageNum = 1; pageNum <= reader.getNumberOfPages(); ++pageNum) {
    copier.addPage(copier.getImportedPage(reader, pageNum) );
  }
}