import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.util.Units;

public class WordInsertPicturesWithShadow {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("source.docx"));
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();

  run.setText("The picture: ");

  InputStream in = new FileInputStream("samplePict.jpeg");
  XWPFPicture picture = run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(100), Units.toEMU(100));
  in.close();  

  picture.getCTPicture().getSpPr().addNewEffectLst().addNewOuterShdw().setBlurRad(50000);
  //picture.getCTPicture().getSpPr().getEffectLst().getOuterShdw().setDist(100000);
  //picture.getCTPicture().getSpPr().getEffectLst().getOuterShdw().setDir(2700000);
  //picture.getCTPicture().getSpPr().getEffectLst().getOuterShdw().setAlgn(
  // org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment.TL);
  //picture.getCTPicture().getSpPr().getEffectLst().getOuterShdw().setRotWithShape(false);
  picture.getCTPicture().getSpPr().getEffectLst().getOuterShdw().addNewPrstClr().setVal(
   org.openxmlformats.schemas.drawingml.x2006.main.STPresetColorVal.BLACK);

  run.setText(" text after the picture.");

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("result.docx");
  document.write(out);
  out.close();
  document.close();
 }
}