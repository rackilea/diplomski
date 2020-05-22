import org.apache.poi.ss.usermodel.*;
import java.io.*;

import java.util.Arrays;

class ReadColorsFromExcel {

 public static void main(String[] args) throws Exception{

  InputStream inp = new FileInputStream("MyFile.xlsx");
  Workbook workbook = WorkbookFactory.create(inp);
  Sheet sheet = workbook.getSheetAt(0);

  int lastRow = 12;
  int lastCol = 6;

  for (int rowNum = 0; rowNum < lastRow; rowNum++) {
   Row row = sheet.getRow(rowNum);
   if (row == null) {
    row = sheet.createRow(rowNum);
   }
   CellStyle rowStyle = row.getRowStyle(); // if the whole row has a style
   for (int colNum = 0; colNum < lastCol; colNum++) {
    CellStyle colStyle = sheet.getColumnStyle(colNum); // if the whole column has a style
    Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
    CellStyle cellStyle = cell.getCellStyle(); // cellStyle is always not-null
    String color = "none";
    ExtendedColor extendedColor = (ExtendedColor)cellStyle.getFillForegroundColorColor(); // first we try cellStyle
    if (extendedColor == null && rowStyle != null) extendedColor = (ExtendedColor)rowStyle.getFillForegroundColorColor(); // now we try rowStyle
    if (extendedColor == null && colStyle != null) extendedColor = (ExtendedColor)colStyle.getFillForegroundColorColor(); // at last we try colStyle
    if (extendedColor != null) {
     byte[] bytes = extendedColor.getRGB();
     color = Arrays.toString(bytes);
    }
    System.out.println("Cell " + cell.getAddress() + " of type " + cell.getCellType() + " has color " + color);
   }
  }
 }
}