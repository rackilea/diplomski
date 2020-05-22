import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.streaming.*;

public class CreateExcelSXSSFFromXLSM {

 public static void main(String[] args) throws Exception {

  XSSFWorkbook templateWorkbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("Workbook.xlsm"));
  Sheet sheet = templateWorkbook.getSheet("Sheet1");
  for (Row row : sheet) {
   for (Cell cell : row) {
    System.out.println(cell);
    if (cell.getColumnIndex() == 0) cell.setCellValue("changed in template");
   }
  }

  int lastRowInTemplate = sheet.getLastRowNum();

  SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(templateWorkbook); 
  SXSSFSheet sxssfSheet = sxssfWorkbook.getSheet("Sheet1");
  for (int r = lastRowInTemplate + 1; r < lastRowInTemplate + 10; r++) {
   SXSSFRow row = sxssfSheet.createRow(r);
   for (int c = 0; c < 10; c++) {
    SXSSFCell cell = row.createCell(c);
    cell.setCellValue("R" + (r+1) + "C" + (c+1));
   }
  }

  FileOutputStream out = new FileOutputStream("WorkbookNew.xlsm");
  sxssfWorkbook.write(out);
  out.close();
  sxssfWorkbook.close();
  sxssfWorkbook.dispose();
 }
}