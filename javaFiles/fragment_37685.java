import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

class ExcelCellStyleAllColumns
 {

 public static void main(String[] args) {
  try {

    Workbook wb = new XSSFWorkbook();

    Font font = wb.createFont();
    font.setFontHeightInPoints((short)24);
    font.setFontName("Courier New");
    font.setItalic(true);
    font.setBold(true);

    CellStyle style = wb.createCellStyle();
    style.setFont(font);

    Sheet sheet = wb.createSheet();

    org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol cTCol = 
      ((XSSFSheet)sheet).getCTWorksheet().getColsArray(0).addNewCol();
    cTCol.setMin(1);
    cTCol.setMax(16384);
    cTCol.setWidth(12.7109375);
    cTCol.setStyle(style.getIndex());

    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue("test");
    cell.setCellStyle(style);

    FileOutputStream os = new FileOutputStream("ExcelCellStyleAllColumns.xlsx");
    wb.write(os);
    os.close();

  } catch (IOException ioex) {
  }
 }
}