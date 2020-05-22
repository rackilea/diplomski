import java.io.*;

import org.apache.poi.util.Units;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTShape;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

import org.w3c.dom.Node;

import java.math.BigInteger;

public class CreateWordHeaderFooterTextBoxPicture {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The Body:");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum....");

  // create header start
  XWPFHeaderFooterPolicy headerFooterPolicy = doc.createHeaderFooterPolicy();
  XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

  // header's first paragraph
  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);

  // create tab stops
  CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
  tabStop.setVal(STTabJc.CENTER);
  int twipsPerInch =  1440;
  tabStop.setPos(BigInteger.valueOf(3 * twipsPerInch));

  tabStop = paragraph.getCTP().getPPr().getTabs().addNewTab();
  tabStop.setVal(STTabJc.RIGHT);
  twipsPerInch =  1440;
  tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

  // first run in header's first paragraph, to be for first text box
  run = paragraph.createRun(); 

  // create inline text box in run
  CTGroup ctGroup = CTGroup.Factory.newInstance();

  CTShape ctShape = ctGroup.addNewShape();
  ctShape.setStyle("width:80pt;height:24pt");
  CTTxbxContent ctTxbxContent = ctShape.addNewTextbox().addNewTxbxContent();
  XWPFParagraph textboxparagraph = new XWPFParagraph(ctTxbxContent.addNewP(), (IBody)header);
  XWPFRun textboxrun = textboxparagraph.createRun();
  textboxrun.setText("The TextBox 1...");
  textboxrun.setFontSize(10);

  Node ctGroupNode = ctGroup.getDomNode(); 
  CTPicture ctPicture = CTPicture.Factory.parse(ctGroupNode);
  CTR cTR = run.getCTR();
  cTR.addNewPict();
  cTR.setPictArray(0, ctPicture);

  // add tab to run
  run.addTab();

  // second run in header's first paragraph, to be for logo picture
  run = paragraph.createRun();  

  // add the picture in the headers run
  String imgFile="Logo.png";
  XWPFPicture picture = run.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(195), Units.toEMU(22));

  String blipID = "";
  for(XWPFPictureData picturedata : header.getAllPackagePictures()) {
   blipID = header.getRelationId(picturedata);
  }
  picture.getCTPicture().getBlipFill().getBlip().setEmbed(blipID);

  // add tab to run
  run.addTab();

  // third run in header's first paragraph, to be for second text box
  run = paragraph.createRun();  

  // create inline text box in run
  ctGroup = CTGroup.Factory.newInstance();

  ctShape = ctGroup.addNewShape();
  ctShape.setStyle("width:80pt;height:24pt");
  ctTxbxContent = ctShape.addNewTextbox().addNewTxbxContent();
  textboxparagraph = new XWPFParagraph(ctTxbxContent.addNewP(), (IBody)header);
  textboxrun = textboxparagraph.createRun();
  textboxrun.setText("The TextBox 2...");
  textboxrun.setFontSize(10);

  ctGroupNode = ctGroup.getDomNode(); 
  ctPicture = CTPicture.Factory.parse(ctGroupNode);
  cTR = run.getCTR();
  cTR.addNewPict();
  cTR.setPictArray(0, ctPicture);

  // create header end


  // create footer start
  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

  paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  run = paragraph.createRun();  
  run.setText("The Footer:");


  doc.write(new FileOutputStream("test.docx"));

 }
}