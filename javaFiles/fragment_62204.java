import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordTextAfterTable {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTextAfterTable.docx"));

  XWPFTable table = document.getTableArray(0);

  org.apache.xmlbeans.XmlCursor cursor = table.getCTTbl().newCursor();
  cursor.toEndToken(); //now we are at end of the CTTbl
  //there always must be a next start token. Either a p or at least sectPr.
  while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START);
  XWPFParagraph newParagraph = document.insertNewParagraph(cursor);
  XWPFRun run = newParagraph.createRun(); 
  run.setText("inserted new text");

  document.write(new FileOutputStream("WordTextAfterTableNew.docx"));
  document.close();
 }
}