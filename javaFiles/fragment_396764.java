import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.streaming.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

public class SXSSFTest {

 public static void main(String[] args) throws Exception {

  // first create SXSSFTest.xlsx using SXSSF ============================================

  String[][] data1 = new String[][]{
   new String[]{"A1", "B1", "C1"},
   new String[]{"A2", "B2", "C2"},
   new String[]{"A3", "B3", "C3"},
   new String[]{"A4", "B4", "C4"}
  };

  SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
  //SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(new XSSFWorkbook(), 2, true, true);

  SXSSFSheet sxssfSheet = sxssfWorkbook.createSheet();

  int r = 0;
  for (String[] rowValues : data1) {
   SXSSFRow row = sxssfSheet.createRow(r++);
   int c = 0;
   for (String value : rowValues) {
    SXSSFCell cell = row.createCell(c++);
    cell.setCellValue(value);
   }
  }

  FileOutputStream outputStream = new FileOutputStream("SXSSFTest.xlsx");
  sxssfWorkbook.write(outputStream);
  outputStream.close();
  sxssfWorkbook.dispose();
  sxssfWorkbook.close();

  // now reread the SXSSFTest.xlsx and update it using XSSF =============================

  String[][] data2 = new String[][]{
   new String[]{"A2 New", "B2 New", "C2 New"},
   new String[]{"A3 New", "B3 New", "C3 New"}
  };

  XSSFWorkbook xssfWorkbook = (XSSFWorkbook)WorkbookFactory.create(
                               new FileInputStream("SXSSFTest.xlsx"));

  XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

  r = 1;
  for (String[] rowValues : data2) {
   XSSFRow row = xssfSheet.getRow(r++); if (row == null) row = xssfSheet.createRow(r++);
   int c = 0;
   for (String value : rowValues) {
    XSSFCell cell = row.getCell(c++); 
    if (cell != null) { // cell was already there
     if (cell.getCTCell().getT() == STCellType.INLINE_STR) { // cell has inline string in it
      if (cell.getCTCell().isSetIs()) { // inline string has is element
       cell.getCTCell().getIs().setT(value); // set t element in is element
      } else {
       cell.getCTCell().setV(value); // set v element of inline string
      }
     } else {
      cell.setCellValue(value); // set shared string cell value
     }
    } else {
     cell = row.createCell(c++);
     cell.setCellValue(value);
    }
   }
  }

  outputStream = new FileOutputStream("XSSFTest.xlsx");
  xssfWorkbook.write(outputStream);
  outputStream.close();   
  xssfWorkbook.close();

 }
}