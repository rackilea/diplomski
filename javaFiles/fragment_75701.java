import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import java.awt.Color;

public class CreatePPTXSheetsTransition {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow();
  XSLFSlide slide = slideShow.createSlide();
  if (slide.getXmlObject().getCSld().getBg() == null) slide.getXmlObject().getCSld().addNewBg();
  slide.getBackground().setFillColor(Color.BLUE);
  slide.getXmlObject().addNewTransition().addNewDissolve();
  slide = slideShow.createSlide();
  if (slide.getXmlObject().getCSld().getBg() == null) slide.getXmlObject().getCSld().addNewBg();
  slide.getBackground().setFillColor(Color.RED);
  slide.getXmlObject().addNewTransition().addNewWheel().setSpokes(8);

  FileOutputStream out = new FileOutputStream("CreatePPTXSheetsTransition.pptx");
  slideShow.write(out);
  out.close();
 }
}