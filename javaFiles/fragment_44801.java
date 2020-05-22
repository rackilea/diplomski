import java.io.FileInputStream;

import org.apache.poi.xslf.usermodel.*;

import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

import java.util.List;

public class PowerPointReadNotes {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream("PowerPointHavingNotes.pptx"));

  List<XSLFSlide> slides = slideShow.getSlides();
  for (XSLFSlide slide : slides) {
   XSLFNotes notes = slide.getNotes();
   for (XSLFShape shape : notes) {
    CTShape cTShape = (CTShape)shape.getXmlObject();
    STPlaceholderType.Enum type = cTShape.getNvSpPr().getNvPr().getPh().getType();
    System.out.println("type: " + type); 
    if (type == STPlaceholderType.BODY) { // get only shapes of type BODY
     if (shape instanceof XSLFTextShape) {
      XSLFTextShape textShape = (XSLFTextShape) shape;
      for (XSLFTextParagraph paragraph : textShape) {
       System.out.println(paragraph.getText());
      }
     }
    }
   }
  }
 }
}