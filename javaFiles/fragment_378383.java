public void importFDF(PDDocument pdfDocument, FDFDocument fdfDocument) throws IOException
{
  PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
  PDAcroForm acroForm = docCatalog.getAcroForm();
  acroForm.setCacheFields(true);
  acroForm.importFDF(fdfDocument);
}