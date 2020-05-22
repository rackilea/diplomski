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

   if (sheet instanceof XSSFSheet) {  
    XSSFSheet xSSFSheet = (XSSFSheet)sheet;
    // correcting bug that shiftRows does not adjusting references of the cells
    // if row 3 is shifted down, then reference in the cells remain r="A3", r="B3", ...
    // they must be adjusted to the new row thoug: r="A4", r="B4", ...
    // apache poi 3.17 has done this properly but had have other bugs in shiftRows.
    for (int r = xSSFSheet.getFirstRowNum(); r < sheet.getLastRowNum() + 1; r++) {
     XSSFRow row = xSSFSheet.getRow(r); 
     if (row != null) {
      long rRef = row.getCTRow().getR();
      for (Cell cell : row) {
       String cRef = ((XSSFCell)cell).getCTCell().getR();
       ((XSSFCell)cell).getCTCell().setR(cRef.replaceAll("[0-9]", "") + rRef);
      }
     }
    }
    // end correcting bug
   }

   workbook.write(out);
  } 
 }
}