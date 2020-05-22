import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

class WriteQuotePrefix {

 public static void main(String[] args) {
  try {

   Workbook wb = new XSSFWorkbook();

   CellStyle style = wb.createCellStyle();
   ((XSSFCellStyle)style).getCoreXf().setQuotePrefix(true);

   Sheet sheet = wb.createSheet();
   Row row = sheet.createRow(0);
   Cell cell = row.createCell(0);
   cell.setCellStyle(style);
   cell.setCellValue("1234");

   FileOutputStream fileOut = new FileOutputStream("WriteQuotePrefix.xlsx");
   wb.write(fileOut);
   fileOut.close();

  } catch (IOException ioex) {
  }
 }
}