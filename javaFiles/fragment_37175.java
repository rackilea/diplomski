import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class CellTypeErrorTest {

 public static void main(String[] args) {
  Workbook wb = new XSSFWorkbook();
  Sheet sheet = wb.createSheet("Sheet1");
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);

  //The following works, but it makes no sense, because the cell will have no real content.
  //If you wants to see, how this will be shown into the Workbook, then comment out the
  //following code that overwrites the Cell with numeric content.
  cell.setCellType(Cell.CELL_TYPE_ERROR);
  cell.setCellErrorValue(FormulaError.DIV0.getCode());
  System.out.println("error cell value-"+ FormulaError.forInt(cell.getErrorCellValue()).getString());

  //If you put real content in the cell, then the CELL_TYPE_ERROR goes away, if the content 
  //not produces ERROR.
  cell.setCellValue(234);
  System.out.println(cell.getCellType()); //0 == CELL_TYPE_NUMERIC

  //If you put a Formula in the Cell, it will not be evaluated automatically.
  //So there is no error, even the formula will produce error if it will be evaluated.
  cell = row.createCell(1);
  cell.setCellFormula("1/0");
  System.out.println(cell.getCellType()); //2 == CELL_TYPE_FORMULA

  //It you need to check if a formula produces error, then you have to evaluate it.
  FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
  CellValue cellValue = evaluator.evaluate(cell);
  System.out.println(cellValue.getCellType()); //5 == CELL_TYPE_ERROR
  if (cellValue.getCellType() == Cell.CELL_TYPE_ERROR) {
   System.out.println("error cell value-"+ FormulaError.forInt(cellValue.getErrorValue()).getString());
  }

  try {
   FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
   wb.write(fileOut);
   fileOut.close();
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }

 }
}