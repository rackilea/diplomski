String textOfPdf;
PDDocument doc = PDDocument.load("doc");
try {
    textOfPdf = pdfs.getText(doc);
} finally {
    doc.close();
}