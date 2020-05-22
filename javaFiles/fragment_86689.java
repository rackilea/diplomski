import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class ExcelReadShiftRowsAndWrite {

 public static void main(String[] args) throws Exception {
  //String fileIn= "TestIn.xls";
  //String fileOut= "TestOut.xls";
  String fileIn= "TestIn.xlsx";
  String fileOut= "TestOut.xlsx";

  try (Workbook workbook = WorkbookFactory.create(new FileInputStream(fileIn));
       FileOutputStream out = new FileOutputStream(fileOut)) {

   Sheet sheet = workbook.getSheet("Sheet1");

   sheet.shiftRows(4, sheet.getLastRowNum(), 1); //shifts rows between row 5 (index 4) and last row one row down

   workbook.write(out);
  } 
 }
}