PDFTextStripper tStripper = new PDFTextStripper();
for (int p = 1; p <= document.getNumberOfPages(); ++p)
{
    stripper.setStartPage(p); // 1-based
    stripper.setEndPage(p); // 1-based
    String pdfFileInText = tStripper.getText(document);
    processText(pdfFileInText);
}