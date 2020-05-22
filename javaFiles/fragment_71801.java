import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTTextbox;

import org.w3c.dom.Node;

public class CreateWordShapes {

 public static void appendCalloutShape(XWPFRun run, String left, String top, String width, String height, 
                                       String strokecolor, String fillcolor, String calloutext, boolean hashandles) throws Exception {
  CTGroup ctGroup = CTGroup.Factory.newInstance();

  CTShape ctShape = ctGroup.addNewShape();
  ctShape.setCoordsize("21600,21600");
  if (hashandles) { //is not Libreoffice Writer compatible
   ctShape.setAdj("" + 21600*1/3 + ",21600");
   CTFormulas cTFormulas = ctShape.addNewFormulas();
   cTFormulas.addNewF().setEqn("val #0");
   cTFormulas.addNewF().setEqn("val #1");
   ctShape.setPath2("m 1,1 l 1," + 21600*2/3 + ", " + 21600*1/3 + "," + 21600*2/3 + ", @0,@1, " + 21600*2/3 + "," + 21600*2/3 + ", 21600," + 21600*2/3 + ", 21600,1 x e");
   ctShape.addNewHandles().addNewH().setPosition("#0,#1");
  } else { // is Libreoffice Writer compatible
   ctShape.setPath2("m 1,1 l 1," + 21600*2/3 + ", " + 21600*1/3 + "," + 21600*2/3 + ", " + 21600*1/3 + ",21600, " + 21600*2/3 + "," + 21600*2/3 + ", 21600," + 21600*2/3 + ", 21600,1 x e");
  }

  ctShape.addNewPath().setTextboxrect("1,1,21600," + 21600*2/3);

  ctShape.setStyle("position:absolute;margin-left:" + left + ";margin-top:" + top + ";width:" + width + ";height:" + height + ";z-index:251659264;visibility:visible;rotation:0;");
  ctShape.setStrokecolor(strokecolor);
  ctShape.setFillcolor(fillcolor);

  CTTextbox cTTextbox = ctShape.addNewTextbox();

  CTTxbxContent ctTxbxContent = cTTextbox.addNewTxbxContent();
  XWPFParagraph textboxparagraph = new XWPFParagraph(ctTxbxContent.addNewP(), run.getDocument());
  XWPFRun textboxrun = null;
  String[] lines = calloutext.split("\n");
  for (int i = 0; i < lines.length; i++) {
   textboxrun = textboxparagraph.createRun();
   textboxrun.setText(lines[i]);
   textboxrun.addBreak();
  }

  Node ctGroupNode = ctGroup.getDomNode(); 
  CTPicture ctPicture = CTPicture.Factory.parse(ctGroupNode);
  CTR cTR = run.getCTR();
  cTR.addNewPict();
  cTR.setPictArray(0, ctPicture);
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run =  paragraph.createRun();  
  run.setText("Callout shape over text: Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor Lorem ipsum semit dolor.");

  appendCalloutShape(run, "200pt", "0", "1in", "1in", "black", "#00FF00", "The callout\ntext...", false);

  paragraph = document.createParagraph();
  paragraph = document.createParagraph();
  paragraph = document.createParagraph();
  paragraph = document.createParagraph();
  run =  paragraph.createRun();  
  run.setText("Callout shape:");

  appendCalloutShape(run, "1in", "-150px", "100px", "150px", "#0000FF", "yellow", "The callout\ntext...", true);


  FileOutputStream out = new FileOutputStream("test.docx");
  document.write(out);
  out.close();
  document.close();
 }
}