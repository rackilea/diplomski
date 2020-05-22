import java.io.FileInputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.Placeholder;

import java.util.List;

public class PowerPointReadNotesHL {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream("PowerPointHavingNotes.pptx"));

  List<XSLFSlide> slides = slideShow.getSlides();
  for (XSLFSlide slide : slides) {
   XSLFNotes notes = slide.getNotes();
   for (XSLFShape shape : notes) {
    Placeholder placeholder = shape.getPlaceholder();
    System.out.println("placeholder: " + placeholder); 
    if (placeholder == Placeholder.BODY) { // get only shapes of type BODY
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