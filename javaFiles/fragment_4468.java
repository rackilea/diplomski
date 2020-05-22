public class App {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();

  doc.createTOC();
  addCustomHeadingStyle(doc, "heading 1", 1);  
  addCustomHeadingStyle(doc, "heading 2", 2);  

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();


  CTP ctP = paragraph.getCTP();
  CTSimpleField toc = ctP.addNewFldSimple();
  toc.setInstr("TOC \\h");
  toc.setDirty(STOnOff.TRUE);

  XWPFRun run=paragraph.createRun();  
  run.setText("The Body:");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum");
  paragraph.setStyle("heading 1");  


  paragraph = doc.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum");
  paragraph.setStyle("heading 2");  


  paragraph = doc.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum");
  FileOutputStream fos = new FileOutputStream("D:\\toc.docx");
    doc.write(fos);
 }
 private static void addCustomHeadingStyle(XWPFDocument docxDocument, String strStyleId, int headingLevel) {  

     CTStyle ctStyle = CTStyle.Factory.newInstance();  
     ctStyle.setStyleId(strStyleId);  

     CTString styleName = CTString.Factory.newInstance();  
     styleName.setVal(strStyleId);  
     ctStyle.setName(styleName);  

     CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();  
     indentNumber.setVal(BigInteger.valueOf(headingLevel));  

     // lower number > style is more prominent in the formats bar  
     ctStyle.setUiPriority(indentNumber);  

     CTOnOff onoffnull = CTOnOff.Factory.newInstance();  
     ctStyle.setUnhideWhenUsed(onoffnull);  

     // style shows up in the formats bar  
     ctStyle.setQFormat(onoffnull);  

     // style defines a heading of the given level  
     CTPPr ppr = CTPPr.Factory.newInstance();  
     ppr.setOutlineLvl(indentNumber);  
     ctStyle.setPPr(ppr);  

     XWPFStyle style = new XWPFStyle(ctStyle);  

     // is a null op if already defined  
     XWPFStyles styles = docxDocument.createStyles();  

     style.setType(STStyleType.PARAGRAPH);  
     styles.addStyle(style);  

 }  

 }