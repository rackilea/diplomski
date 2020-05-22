File outputFile = new File(System.getProperty("user.home"), "output.pdf");
PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputFile));
Document layoutDocument = new Document(pdfDocument);

layoutDocument.add(new Paragraph("\u00A0\u00A0\u00A0Lorem Ipsum"));
layoutDocument.add(new Paragraph("Lorem Ipsum"));
layoutDocument.close();