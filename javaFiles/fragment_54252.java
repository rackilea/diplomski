import java.io.File;
import java.io.FileOutputStream;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class CreateWordTableMerge2 {

 //merging horizontally by setting grid span instead of using CTHMerge
 static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
  XWPFTableCell cell = table.getRow(row).getCell(fromCol);
  // Try getting the TcPr. Not simply setting an new one every time.
  CTTcPr tcPr = cell.getCTTc().getTcPr();
  if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
  // The first merged cell has grid span property set
  if (tcPr.isSetGridSpan()) {
   tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  } else {
   tcPr.addNewGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  }
  // Cells which join (merge) the first one, must be removed
  for(int colIndex = toCol; colIndex > fromCol; colIndex--) {
   table.getRow(row).getCtRow().removeTc(colIndex);
   table.getRow(row).removeCell(colIndex);
  }
 }

 static void setColumnWidth(XWPFTable table, int row, int col, int width) {
  CTTblWidth tblWidth = CTTblWidth.Factory.newInstance();
  tblWidth.setW(BigInteger.valueOf(width));
  tblWidth.setType(STTblWidth.DXA);
  CTTcPr tcPr = table.getRow(row).getCell(col).getCTTc().getTcPr();
  if (tcPr != null) {
   tcPr.setTcW(tblWidth);
  } else {
   tcPr = CTTcPr.Factory.newInstance();
   tcPr.setTcW(tblWidth);
   table.getRow(row).getCell(col).getCTTc().setTcPr(tcPr);
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create table
  XWPFTable table = document.createTable(3, 10);

  //defining the column widths for the grid
  //column width values are in unit twentieths of a point (1/1440 of an inch)
  int defaultColWidth = 1*1440*6/10; // 10 columns fits to 6 inches 

  //create CTTblGrid for this table with widths of the 10 columns. 
  //necessary for Libreoffice/Openoffice to accept the column widths.
  //first column
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(defaultColWidth));
  setColumnWidth(table, 0, 0, defaultColWidth);
  //other columns
  for (int col = 1; col < 10; col++) {
   table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(defaultColWidth));
   setColumnWidth(table, 0, col, defaultColWidth);
  }

  //using the merge method

  mergeCellHorizontally(table, 1, 0, 4);
  mergeCellHorizontally(table, 1, 3, 5);

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("create_table.docx"); 
  document.write(out);
  out.close();

 }
}