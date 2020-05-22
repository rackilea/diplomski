import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CreateWord {

 public static void main(String[] args) throws Exception {

  String content = Files.readString(new File("ArabicTextFile.txt").toPath(), StandardCharsets.UTF_16);

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();

  // set bidirectional text support on
  CTP ctp = paragraph.getCTP();
  CTPPr ctppr = ctp.getPPr();
  if (ctppr == null) ctppr = ctp.addNewPPr();
  ctppr.addNewBidi().setVal(STOnOff.ON);

  XWPFRun run=paragraph.createRun(); 
  run.setBold(true);
  run.setFontSize(22);
  run.setText(content);

  FileOutputStream out = new FileOutputStream("CreateWord.docx");
  document.write(out);
  out.close();
  document.close();

 }
}