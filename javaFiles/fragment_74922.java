import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;

public class CreateExcelNumberFormat {

 public static void main(String[] args) throws Exception {
  SXSSFWorkbook workbook = new SXSSFWorkbook(100);

  DataFormat dataformat = workbook.createDataFormat();
  CellStyle cellStyleCurrency = workbook.createCellStyle();
  cellStyleCurrency.setDataFormat(dataformat.getFormat("#\\ ###\\ ##0.00\\ [$€-40C];[RED]\\-#\\ ###\\ ##0.00\\ [$€-40C]")); 

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(1);
  Cell cell = row.createCell(0);

  cell.setCellValue(123456.78);
  cell.setCellStyle(cellStyleCurrency);

  ((SXSSFSheet)sheet).trackColumnForAutoSizing(0);
  sheet.autoSizeColumn(0);

  workbook.write(new FileOutputStream("CreateExcelNumberFormat.xlsx"));
  workbook.close();
  workbook.dispose();
 }
}