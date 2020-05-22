import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.*;

public class CreateWordTableBorders {

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create the table
  XWPFTable table = document.createTable(3,3);
  table.setWidth("100%");
  for (int row = 0; row < 3; row++) {
   for (int col = 0; col < 3; col++) {
    table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
   }
  }

  //set borders
  table.setTopBorder(XWPFTable.XWPFBorderType.THICK_THIN_LARGE_GAP, 32, 0, "FF0000");
  table.setBottomBorder(XWPFTable.XWPFBorderType.THICK_THIN_LARGE_GAP, 32, 0, "FF0000");
  table.setLeftBorder(XWPFTable.XWPFBorderType.THICK_THIN_LARGE_GAP, 32, 0, "FF0000");
  table.setRightBorder(XWPFTable.XWPFBorderType.THICK_THIN_LARGE_GAP, 32, 0, "FF0000");
  table.setInsideHBorder(XWPFTable.XWPFBorderType.DOT_DASH, 16, 0, "00FF00");
  table.setInsideVBorder(XWPFTable.XWPFBorderType.DOTTED, 24, 0, "0000FF");

  paragraph = document.createParagraph();

  FileOutputStream fileOut = new FileOutputStream("create_table.docx"); 
  document.write(fileOut);
  fileOut.close();
  document.close();
 }
}