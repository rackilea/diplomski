import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcelFormattedValues {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  DataFormat format = workbook.createDataFormat();

  // structure which holds data objects per row and cell 
  Object[][] data = new Object[][]{
   new Object[]{"Price", "Percent"},
   new Object[]{203.9483495949, 0.53282},
   new Object[]{0.8375733, 0.009383484}
  };

  // structure which holds data formats per column
  short currencyDataFormat = format.getFormat("$#,##0.00");
  short percentDataFormat = format.getFormat("0.00%");
  short[] dataFormats = {currencyDataFormat, percentDataFormat};

  Sheet sheet = workbook.createSheet();
  Row row;
  int firstRow = 1; // first row is second row
  int r = 0; // loop variable for row
  Cell cell;
  int firstCol = 1; // first column is column B
  int c = 0; // loop variable for column
  for (Object[] dataRow : data) {
   row = sheet.createRow(firstRow + r);
   c = 0;
   for (Object dataValue : dataRow) {
    cell = row.createCell(firstCol + c);
    CellUtil.setCellStyleProperty(cell, CellUtil.DATA_FORMAT, dataFormats[c]);
    if (dataValue instanceof String) {
     cell.setCellValue((String)dataValue);
    } else if (dataValue instanceof Double) {
     cell.setCellValue((Double)dataValue);
    }
    c++;
   }
   r++;
  }

  FileOutputStream out = new FileOutputStream("Excel.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}