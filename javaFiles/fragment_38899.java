import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.GregorianCalendar;

import java.awt.Desktop;

class CreateExcelAndOpenFile {

 private Workbook workbook;
 private Sheet sheet;

 public CreateExcelAndOpenFile() {
  this.workbook = new XSSFWorkbook();
  this.sheet = this.workbook.createSheet(); 
 }

 public Workbook getWorkbook() {
  return this.workbook;
 }

 public boolean writeDataInSheet(Object[][] data, String[] columnCellTypes, CellStyle[] columnCellStyles) {

  try {
   FormulaEvaluator formulaEvaluator = this.workbook.getCreationHelper().createFormulaEvaluator();
   for (int r = 0; r < data.length; r++) {
    Row row = this.sheet.createRow(r);
    for (int c = 0; c < data[0].length; c++) {
     Cell cell = row.createCell(c);
     if (r == 0) {
      cell.setCellValue((String)data[r][c]); // header row, all String
      cell.setCellStyle(columnCellStyles[c]);
     } else if ("number".equals(columnCellTypes[c]) && data[r][c] instanceof Double) {
      cell.setCellValue((Double)data[r][c]);
      cell.setCellStyle(columnCellStyles[c]);
     } else if ("date".equals(columnCellTypes[c]) && data[r][c] instanceof GregorianCalendar) {
      cell.setCellValue((GregorianCalendar)data[r][c]);
      cell.setCellStyle(columnCellStyles[c]);
     } else if ("text".equals(columnCellTypes[c]) && data[r][c] instanceof String) {
      cell.setCellValue((String)data[r][c]);
      cell.setCellStyle(columnCellStyles[c]);
     } else if ("formula".equals(columnCellTypes[c]) && data[r][c] instanceof String) {
      cell.setCellFormula((String)data[r][c]);
      cell.setCellStyle(columnCellStyles[c]);
      formulaEvaluator.evaluateFormulaCell(cell);
     }
    }
   }
  } catch(Exception ex) {
   ex.printStackTrace();
   return false;
  }
  return true;
 }

 public boolean writeExcelFile(String fileName) {
  try (FileOutputStream fileOut = new FileOutputStream(fileName) ) {
   // auto fit content
   int columnsCountInHeaderRow = this.sheet.getRow(0).getLastCellNum();
   for(int i = 0; i < columnsCountInHeaderRow; i++) {
    this.sheet.autoSizeColumn((short)i);
   }
   // write the output to a file
   this.workbook.write(fileOut);
   this.workbook.close();
  } catch(Exception ex) {
   ex.printStackTrace();
   return false;
  }
  return true;
 }

 public boolean openExcelFile(String fileName) {
  try {
   File file = new File(fileName);
   Desktop.getDesktop().open(file);
  } catch(Exception ex) {
   ex.printStackTrace();
   return false;
  }
  return true;
 }

 public static void main(String[] args) throws Exception {

  String fileName = "./Excel.xlsx";

  CreateExcelAndOpenFile application = new CreateExcelAndOpenFile();

  Object[][] data = new Object[][] {
   new Object[] {"Name", "Value", "Date", "Formatted value", "Formula"},
   new Object[] {"Lorem", 123.456789, new GregorianCalendar(2019, 0, 15), 123.456789, "ROUND(B2,2)"},
   new Object[] {"Ipsum", 1234.56789, new GregorianCalendar(2019, 5, 15), 1234.56789, "ROUND(B3,2)"}
  };

  String[] columnCellTypes = new String[]{"text", "number", "date", "number", "formula"};

  DataFormat dataFormat = application.getWorkbook().createDataFormat();
  CellStyle dateStyle = application.getWorkbook().createCellStyle();
  dateStyle.setDataFormat(dataFormat.getFormat("DDDD, MMMM, DD, YYYY"));
  CellStyle numberStyle = application.getWorkbook().createCellStyle();
  numberStyle.setDataFormat(dataFormat.getFormat("#,##0.00 \" Coins\""));
  CellStyle[] columnCellStyles = new CellStyle[]{null, null, dateStyle, numberStyle, null};

  boolean success = application.writeDataInSheet(data, columnCellTypes, columnCellStyles);
  System.out.println(success);
  if (success) {
   success = application.writeExcelFile(fileName);
   System.out.println(success);
   if (success) {
    success = application.openExcelFile(fileName);
    System.out.println(success);
    if (success) {
     System.out.println("Done successfully");
    } 
   }
  }
 }
}