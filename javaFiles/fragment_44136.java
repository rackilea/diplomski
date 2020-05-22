import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.math.BigDecimal;
import java.util.Random;

class CreateExcelCellNumberFormat {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   CellStyle style = workbook.createCellStyle();
   style.setDataFormat(workbook.createDataFormat().getFormat("#,###.00"));

   Sheet sheet = workbook.createSheet();

   for (int r = 0; r < 10; r++) {
    Cell cell = sheet.createRow(r).createCell(0);
    cell.setCellStyle(style);

    BigDecimal bigDecimal = new BigDecimal(new Random().nextDouble() * 10000000000000d);
    cell.setCellValue(bigDecimal.doubleValue());

   }

   sheet.setColumnWidth(0, 25 * 256);

   workbook.write(fileout);
  }
 }
}