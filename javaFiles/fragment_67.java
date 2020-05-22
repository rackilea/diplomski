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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

public class CreateWordTableMerge {

 static void mergeCellVertically(XWPFTable table, int col, int fromRow, int toRow) {
  for(int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
   XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
   CTVMerge vmerge = CTVMerge.Factory.newInstance();
   if(rowIndex == fromRow){
    vmerge.setVal(STMerge.RESTART);
   } else {
    vmerge.setVal(STMerge.CONTINUE);
    for (int i = cell.getParagraphs().size(); i > 0; i--) {
     cell.removeParagraph(0);
    }
    cell.addParagraph();
   }
   CTTcPr tcPr = cell.getCTTc().getTcPr();
   if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
   tcPr.setVMerge(vmerge);
  }
 }

 static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
  XWPFTableCell cell = table.getRow(row).getCell(fromCol);
  CTTcPr tcPr = cell.getCTTc().getTcPr();
  if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
  if (tcPr.isSetGridSpan()) {
   tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  } else {
   tcPr.addNewGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  }
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

  XWPFTable table = document.createTable(9,8);

  for (int row = 0; row < 9; row++) {
   for (int col = 0; col < 8; col++) {
    table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
   }
  }

  int defaultColWidth = 1*1440*6/8; 
  int[] colunmWidths = new int[] {
   defaultColWidth*5/4, defaultColWidth*3/4, defaultColWidth*1/4, defaultColWidth*1/4, 
   defaultColWidth*3/2, defaultColWidth, defaultColWidth, defaultColWidth*2
  };

  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(colunmWidths[0]));
  
  for (int col = 1; col < colunmWidths.length; col++) {
   table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(colunmWidths[col]));
  }

  mergeCellHorizontally(table, 0, 0, 2); 
  setColumnWidth(table, 0, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]);
  mergeCellHorizontally(table, 0, (3-2), (6-2)); 
  setColumnWidth(table, 0, 1, colunmWidths[3]+colunmWidths[4]+colunmWidths[5]+colunmWidths[6]);
  setColumnWidth(table, 0, 2, colunmWidths[7]);

  mergeCellHorizontally(table, 1, 0, 6); 
  setColumnWidth(table, 1, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]+colunmWidths[3]
                              +colunmWidths[4]+colunmWidths[5]+colunmWidths[6]);
  setColumnWidth(table, 1, 1, colunmWidths[7]);

  mergeCellHorizontally(table, 2, 1, 3); 
  setColumnWidth(table, 2, 0, colunmWidths[0]);
  setColumnWidth(table, 2, 1, colunmWidths[1]+colunmWidths[2]+colunmWidths[3]);
  setColumnWidth(table, 2, 2, colunmWidths[4]);
  setColumnWidth(table, 2, 3, colunmWidths[5]);
  setColumnWidth(table, 2, 4, colunmWidths[6]);
  setColumnWidth(table, 2, 5, colunmWidths[7]);

  mergeCellHorizontally(table, 3, 1, 3); 
  setColumnWidth(table, 3, 0, colunmWidths[0]);
  setColumnWidth(table, 3, 1, colunmWidths[1]+colunmWidths[2]+colunmWidths[3]);
  setColumnWidth(table, 3, 2, colunmWidths[4]);
  setColumnWidth(table, 3, 3, colunmWidths[5]);
  setColumnWidth(table, 3, 4, colunmWidths[6]);
  setColumnWidth(table, 3, 5, colunmWidths[7]);

  mergeCellHorizontally(table, 4, 0, 7); 
  setColumnWidth(table, 4, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]+colunmWidths[3]
                              +colunmWidths[4]+colunmWidths[5]+colunmWidths[6]+colunmWidths[7]);

  mergeCellHorizontally(table, 5, 0, 4); 
  mergeCellHorizontally(table, 5, (5-4), (7-4)); 
  setColumnWidth(table, 5, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]+colunmWidths[3]+colunmWidths[4]);
  setColumnWidth(table, 5, 1, colunmWidths[5]+colunmWidths[6]+colunmWidths[7]);

  mergeCellHorizontally(table, 6, 0, 1); 
  mergeCellHorizontally(table, 6, (2-1), (4-1)); 
  mergeCellHorizontally(table, 6, (5-3), (6-3)); 
  setColumnWidth(table, 6, 0, colunmWidths[0]+colunmWidths[1]);
  setColumnWidth(table, 6, 1, colunmWidths[2]+colunmWidths[3]+colunmWidths[4]);
  setColumnWidth(table, 6, 2, colunmWidths[5]+colunmWidths[6]);
  setColumnWidth(table, 6, 3, colunmWidths[7]);

  mergeCellHorizontally(table, 7, 0, 1); 
  mergeCellHorizontally(table, 7, (2-1), (4-1)); 
  mergeCellHorizontally(table, 7, (5-3), (6-3)); 
  setColumnWidth(table, 7, 0, colunmWidths[0]+colunmWidths[1]);
  setColumnWidth(table, 7, 1, colunmWidths[2]+colunmWidths[3]+colunmWidths[4]);
  setColumnWidth(table, 7, 2, colunmWidths[5]+colunmWidths[6]);
  setColumnWidth(table, 7, 3, colunmWidths[7]);

  mergeCellHorizontally(table, 8, 0, 7); 
  setColumnWidth(table, 8, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]+colunmWidths[3]
                              +colunmWidths[4]+colunmWidths[5]+colunmWidths[6]+colunmWidths[7]);

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("create_table.docx"); 
  document.write(out);
  out.close();

 }
}