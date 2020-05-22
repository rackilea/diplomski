import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.xmlbeans.XmlObject;

public class WordRunSelectPath {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordInsertPictures.docx"));
  for (XWPFParagraph paragraph : document.getParagraphs()) {
   for (XWPFRun run : paragraph.getRuns()) {
    String declareNameSpaces =   "declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main'; " 
                       + "declare namespace wp='http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing'; "
                       + "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main'; "
                       + "declare namespace pic='http://schemas.openxmlformats.org/drawingml/2006/picture'; "
                       + "declare namespace r='http://schemas.openxmlformats.org/officeDocument/2006/relationships' ";

    XmlObject[] selectedObjects = run.getCTR().selectPath(
                         declareNameSpaces 
                       + ".//w:drawing/wp:inline/a:graphic/a:graphicData/pic:pic/pic:blipFill/a:blip/@r:embed");
    if (selectedObjects.length > 0) {
     String rID = selectedObjects[0].newCursor().getTextValue();
     System.out.println(rID);
    }
   }
  }

  document.close();
 }
}