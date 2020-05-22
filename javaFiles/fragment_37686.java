import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

class ExcelDefaultCellStyle {

 public static void main(String[] args) {
  try {

    Workbook wb = new XSSFWorkbook();

    Font font = wb.getFontAt((short)0);
    font.setFontHeightInPoints((short)24);
    font.setFontName("Courier New");
    ((XSSFFont)font).setFamily(3);
    ((XSSFFont)font).setScheme(FontScheme.NONE);
    font.setItalic(true);
    font.setBold(true);

    CellStyle style = wb.getCellStyleAt(0);
    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    style.setWrapText(true);

    ((XSSFWorkbook) wb).getStylesSource().getCTStylesheet().addNewCellStyles().addNewCellStyle().setXfId(0);

    ((XSSFCellStyle)style).getStyleXf().addNewAlignment().setVertical(
     org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment.CENTER);
    ((XSSFCellStyle)style).getStyleXf().getAlignment().setWrapText(true);

    Sheet sheet = wb.createSheet();

    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue("test");

    FileOutputStream os = new FileOutputStream("ExcelDefaultCellStyle.xlsx");
    wb.write(os);
    os.close();

  } catch (IOException ioex) {
  }
 }
}