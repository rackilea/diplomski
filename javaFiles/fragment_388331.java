import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelCalculateTimeValues {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();

  CreationHelper createHelper = workbook.getCreationHelper();
  CellStyle styletime = workbook.createCellStyle();
  styletime.setDataFormat(createHelper.createDataFormat().getFormat("hh:mm:ss"));

  Sheet sheet = workbook.createSheet();
  sheet.createRow(0).createCell(0).setCellValue("Start");
  sheet.getRow(0).createCell(1).setCellValue("End");
  sheet.getRow(0).createCell(3).setCellValue("Start");
  sheet.getRow(0).createCell(4).setCellValue("End");

  String[][] tableData = new String[][]{
   {"12:34:00", "22:45:00"},
   {"23:45:00", "01:34:00"},
   {"08:01:00", "13:23:00"}
  };

  int r = 1;
  for (String[] rowData : tableData) {
   Row row = sheet.createRow(r++);
   int c = 0;
   for (String cellData : rowData) {
    Cell cell = row.createCell(c);
    cell.setCellValue(cellData); //this sets string cell data
    cell.setCellStyle(styletime);
    cell = row.createCell(3 + c++);
    cell.setCellValue(DateUtil.convertTime(cellData)); //this sets datetime cell data
    cell.setCellStyle(styletime);
   }
  }

  sheet.createRow(r).createCell(0).setCellFormula("MIN(A2:A4)"); //cannot work because of string values in A2:A4
  sheet.getRow(r).createCell(1).setCellFormula("MIN(B2:B4)"); //cannot work because of string values in B2:B4
  sheet.getRow(r).createCell(3).setCellFormula("MIN(D2:D4)"); //will work
  sheet.getRow(r).createCell(4).setCellFormula("MIN(E2:E4)"); //will work

  workbook.setForceFormulaRecalculation(true);

  workbook.write(new FileOutputStream("ExcelCalculateTimeValues.xlsx"));
  workbook.close();

 }

}