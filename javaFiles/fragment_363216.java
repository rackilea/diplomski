import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateExcelCellWrapText {

 public static void main(String[] args) throws Exception {
  XSSFWorkbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(0);

  CellStyle cellstyle = workbook.createCellStyle();
  cellstyle.setWrapText(true);

  Cell cell = row.createCell(0);
  cell.setCellValue("String cell content\nhaving line wrap.");
  cell.setCellStyle(cellstyle);

  sheet.autoSizeColumn(0);

  workbook.write(new FileOutputStream("CreateExcelCellWrapText.xlsx"));
  workbook.close();
 }
}