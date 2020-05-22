public byte[] mergePdfDocumentsIntoAPdfDocument(List<PdfDocument> pdfDocuments){
    ByteArrayOutputStream mergedPdfStream = new ByteArrayOutputStream();
    PdfDocument resultDoc = new PdfDocument(new PdfWriter(mergedPdfStream));

    for (PdfDocument doc : pdfDocuments) {
        int n = doc.getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            PdfPage page = doc.getPage(i).copyTo(resultDoc);
            resultDoc.addPage(page);
        }
    }

    resultDoc.close();
    return mergedPdfStream.toByteArray();
}