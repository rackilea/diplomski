PDDocument newPdf = PDDocument.load(sourcePdfFile);
  PDPage firstPage=newPdf.getPage(0);
  PDFont pdfFont= PDType1Font.HELVETICA_BOLD;
  int fontSize = 14;
  PDPageContentStream contentStream = new PDPageContentStream(newPdf, firstPage, PDPageContentStream.AppendMode.APPEND,true,true);
  contentStream.setFont(pdfFont, fontSize);
  contentStream.beginText();
  contentStream.newLineAtOffset(200,685);
  contentStream.showText("John");
  contentStream.endText();
  contentStream.close(); // don't forget that one!