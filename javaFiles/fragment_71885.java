import java.io.*;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

public class CreateWordHeader {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run = paragraph.createRun();  
  run.setText("The Body...");

  // create header
  XWPFHeader header = doc.createHeader(HeaderFooterType.FIRST);
  paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);
  run = paragraph.createRun();
  run.setText("First Line in Header...");

  // bottom border line of the paragraph = what Autoformat creates after "---"[Enter]
  paragraph.setBorderBottom(Borders.SINGLE);

  paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);
  run = paragraph.createRun();
  run.setText("Next Line in Header...");

  FileOutputStream out = new FileOutputStream("CreateWordHeader.docx");
  doc.write(out);
  doc.close();
  out.close();


 }
}