public class templateTest {

 public static void main(String[] args) throws IOException { 

   File file = new File("template.pdf");
   PDDocument templatePdf = PDDocument.load(file);
   PDDocument mainDocument = new PDDocument();     

   PDPage myPage = new PDPage();
    mainDocument.addPage(myPage);
   PDPageContentStream contentStream = new PDPageContentStream(mainDocument, myPage, AppendMode.APPEND, true);

   contentStream.beginText();
   // Some text
  // Table 1 (Depending on table 1 size, pdf pages will increase) 

  contentStream.endText();
  contentStream.close();

  // Process of imposing a layer begins here
  PDPageTree destinationPages = mainDocument.getDocumentCatalog().getPages();

  LayerUtility layerUtility = new LayerUtility(mainDocument);

  PDFormXObject firstForm = layerUtility.importPageAsForm(templatePDF, 0);

  AffineTransform affineTransform = new AffineTransform();

  PDPage destPage = destinationPages.get(0);

  layerUtility.wrapInSaveRestore(destPage);
  layerUtility.appendFormAsLayer(destPage, firstForm, affineTransform, "external page");

  mainDocument.save("result.pdf");
  mainDocument.close();
 }
}