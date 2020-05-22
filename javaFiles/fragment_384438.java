PdfReader reader = new PdfReader( templatePDFPath );
Document doc = new Document();
PdfWriter writer = PdfWriter.createInstance( doc, new FileOutputStream("blah.pdf" ) );

PdfImportedPage inputPage = writer.getImportedPage( reader, 1 );

PdfDirectContent curPageContent = writer.getDirectContent();

String extraStuff[] = getExtraStuff();

for (String stuff : extraStuff) {
  curPageContent.saveState();
  curPageContent.addTemplate( inputPage /*, x, y*/ );
  curPageContent.restoreState();

  curPageContent.beginText();
  curPageContent.setTextMatrix(x, y);
  curPageContent.setFontAndSize( someFont, someSize );

  // the actual work:
  curPageContent.showText( stuff );

  curPageContent.EndText();       

  // save the contents of curPageContent out to the file and reset it for the next page.
  doc.newPage();
}