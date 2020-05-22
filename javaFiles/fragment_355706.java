Document doc = null;
PdfDocument pdfDocument = null; //!!!
PdfPage sourcePage = null;
try (   InputStream resource = new FileInputStream(new File(Paths.get("Output").toAbsolutePath()+"/test.pdf"));    ) {  //!!!
   PdfReader pdfReader = new PdfReader(resource); //!!!
   pdfDocument = new PdfDocument(pdfReader); //!!!
   PdfDocumentContentParser contentParser = new PdfDocumentContentParser(pdfDocument);
   MarginFinder strategy = contentParser.processContent(1, new MarginFinder());

   sourcePage = pdfDocument.getPage(1);
   sourcePage.setCropBox(strategy.getBoundingBox());
   sourcePage.setMediaBox(strategy.getBoundingBox());
   //pdfDocument.close(); //!!!
}


try {
   @SuppressWarnings("resource")
   PdfWriter writer = new PdfWriter(new FileOutputStream(new File(Paths.get("Output").toAbsolutePath()+"/final.pdf"))).setSmartMode(true);
   PdfDocument pdfDoc = new PdfDocument(writer);
   pdfDoc.setDefaultPageSize(PageSize.A3.rotate());
   String fonts[] = {Paths.get("fonts").toAbsolutePath() + "/TREBUC.TTF", Paths.get("fonts").toAbsolutePath() + "/TREBUCBD.TTF", Paths.get("fonts").toAbsolutePath() + "/TREBUCBI.TTF",Paths.get("fonts").toAbsolutePath() + "/TREBUCIT.TTF"};
   FontProvider fontProvider = new FontProvider();
   Map<String, PdfFont> pdfFontMap = new HashMap<String, PdfFont>();
   for (String font : fonts) {
       FontProgram fontProgram = FontProgramFactory.createFont(font);
       if (font.endsWith("TREBUC.TTF")) {
           pdfFontMap.put("NORMAL", PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true));
       } else if (font.endsWith("TREBUCBD.TTF")) {
           pdfFontMap.put("BOLD", PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true));
       } else if (font.endsWith("TREBUCBI.TTF")) {
           pdfFontMap.put("BOLD_ITALIC", PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true));
       } else if (font.endsWith("TREBUCIT.TTF")) {
           pdfFontMap.put("ITALIC", PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true));
       }

       fontProvider.addFont(fontProgram);
   }

   TestVisualSummaryNew testVisualSummaryNew = new TestVisualSummaryNew();
   NormalPageHeader headerHandler = testVisualSummaryNew.new NormalPageHeader(Paths.get("images").toAbsolutePath() + "\\logo.png", pdfFontMap);
   pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, headerHandler);
   PageEndEvent pageEndEvent = testVisualSummaryNew.new PageEndEvent(Paths.get("images").toAbsolutePath() + "\\FooterLineExternal.png" ,pdfFontMap);
   pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, pageEndEvent);

   doc = new Document(pdfDoc);
   doc.setTopMargin(55);
   PdfFormXObject xobject = sourcePage.copyAsFormXObject(pdfDoc);
   Rectangle xobjectBoundaryBox = xobject.getBBox().toRectangle();
   xobject.getPdfObject().put(PdfName.Matrix, new PdfArray(new float[] {1, 0, 0, 1, -xobjectBoundaryBox.getLeft(), -xobjectBoundaryBox.getBottom()}));
   Image image = new Image(xobject);
   image.setAutoScale(true);
   doc.add(image);
   pdfDoc.close();
   doc.close();
   System.out.println("Converted to PDF Succesfully >>> convertedSvg_" + uuid + ".pdf");
} catch (Exception e) {
   e.printStackTrace();
   System.out.println("Error Occured while converting to PDF = " + e.getMessage());
}

pdfDocument.close();  //!!!