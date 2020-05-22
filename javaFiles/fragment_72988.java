import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

import java.math.BigInteger;

public class CreateWordHeaderWithTabStops {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run = paragraph.createRun();  
  run.setText("The Body...");

  // create header
  XWPFHeader header = doc.createHeader(HeaderFooterType.FIRST);

  // header's first paragraph
  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);

  // create tab stops
  int twipsPerInch = 1440; //measurement unit for tab stop pos is twips (twentieth of an inch point)

  CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
  tabStop.setVal(STTabJc.CENTER);
  tabStop.setPos(BigInteger.valueOf(3 * twipsPerInch));

  tabStop = paragraph.getCTP().getPPr().getTabs().addNewTab();
  tabStop.setVal(STTabJc.RIGHT);
  tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

  // first run in header's first paragraph, to be for first text box
  run = paragraph.createRun(); 
  run.setText("Left");
  // add tab to run
  run.addTab();

  run = paragraph.createRun(); 
  run.setText("Center");
  // add tab to run
  run.addTab();

  run = paragraph.createRun(); 
  run.setText("Right");

  FileOutputStream out = new FileOutputStream("CreateWordHeaderWithTabStops.docx");
  doc.write(out);
  doc.close();
  out.close();


 }
}