import org.apache.poi.ss.usermodel.*;
import java.io.*;

import java.util.Arrays;

class ReadColorsFromExcel {

 public static void main(String[] args) throws Exception{

  InputStream inp = new FileInputStream("MyFile.xlsx");
  Workbook workbook = WorkbookFactory.create(inp);
  Sheet sheet = workbook.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) { // cell will always be not-null only existing cells are in loop
    CellStyle cellStyle = cell.getCellStyle(); // cellStyle is always not-null
    ExtendedColor extendedColor = (ExtendedColor)cellStyle.getFillForegroundColorColor(); // extendedColor may be null
    String color = "none";
    if (extendedColor != null) {
     byte[] bytes = extendedColor.getRGB();
     color = Arrays.toString(bytes);
    }
    System.out.println("Cell " + cell.getAddress() + " of type " + cell.getCellType() + " has color " + color);
   }
  }
 }
}