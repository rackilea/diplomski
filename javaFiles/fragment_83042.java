import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class CreateExcelHiddenRow {

 public static void main(String[] args) throws Exception {

  //Workbook wb = new HSSFWorkbook();
  Workbook wb = new XSSFWorkbook();

  Sheet sheet = wb.createSheet();

  for (int r = 0; r < 3; r++) {
   Row row = sheet.createRow(r);
   Cell cell = row.createCell(0);
   cell.setCellValue("Row " + (r+1));
  }

  Row row = sheet.getRow(1);
  row.setZeroHeight(true);

  //FileOutputStream out = new FileOutputStream("CreateExcelHiddenRow.xls");   
  FileOutputStream out = new FileOutputStream("CreateExcelHiddenRow.xlsx");   
  wb.write(out);
  out.close();
  wb.close();

 }
}