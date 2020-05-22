import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

class CenteredColumn {

 public static void main(String[] args) {
  try {

   Workbook wb = new XSSFWorkbook();

   Sheet sheet = wb.createSheet("Sheet1");

   CellStyle cellStyle = wb.createCellStyle();
   cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

   sheet.setDefaultColumnStyle(1, cellStyle);

   //Workaround 1: We set setApplyAlignment(true) into the `xf` element's tag in styles.xml.
   //This causes Excel applying alignments from this style to new cells in that column.
   for (int i = 0; i < ((XSSFWorkbook)wb).getStylesSource().getNumCellStyles(); i++) {
    if (((XSSFWorkbook)wb).getStylesSource().getStyleAt(i).equals(cellStyle)) {
     ((XSSFWorkbook)wb).getStylesSource().getCellXfAt(i).setApplyAlignment(true);
    }
   }

   Row row = sheet.getRow(0);
   if (row == null) row = sheet.createRow(0);

   Cell cell = row.getCell(1);
   if (cell == null) cell = row.createCell(1);
   cell.setCellValue("name");
   //Workaround 2: We set the cellStyle to the new cell because POI will not do this itself.
   cell.setCellStyle(cellStyle);

   FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
   wb.write(fileOut);

  } catch (IOException ioex) {
  }
 }
}