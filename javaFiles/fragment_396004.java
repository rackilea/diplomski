import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.*;
import org.apache.poi.ss.util.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class ReadAndWriteExcelHavingTableObject {

 static void writeToExcel(XSSFTable exceltable, JTable table) throws Exception {

  int exceltableStartRow = exceltable.getStartRowIndex();
  int exceltableStartCol = exceltable.getStartColIndex();

  XSSFSheet sheet = (XSSFSheet)exceltable.getParent();

  TableModel model = table.getModel();

  int exceltableEndRow = exceltableStartRow + model.getRowCount(); //as much rows as are in the model
  int exceltableEndCol = exceltable.getEndColIndex();

  //write the content
  for (int r = 0; r < model.getRowCount(); r++) {
   for (int c = 0; c < exceltableEndCol - exceltableStartCol + 1; c++) {
    XSSFRow row = sheet.getRow(exceltableStartRow + 1 + r);
    if (row == null) row = sheet.createRow(exceltableStartRow + 1 + r);
    XSSFCell cell = row.getCell(exceltableStartCol + c);
    if (cell == null) cell = row.createCell(exceltableStartCol + c);

    if (c < model.getColumnCount() && model.getValueAt(r, c) instanceof String) {
     String str = (String)model.getValueAt(r, c);
     cell.setCellValue(str);
    } else if (c < model.getColumnCount() && model.getValueAt(r, c) instanceof Double) {
     Double value = (Double)model.getValueAt(r, c);
     cell.setCellValue(value);
    } else if (c >= model.getColumnCount()) { //formula cells
     XSSFCell firstCell = sheet.getRow(exceltableStartRow + 1).getCell(exceltableStartCol + c);
     if (firstCell.getCellTypeEnum() == CellType.FORMULA) { 
      cell.setCellFormula(firstCell.getCellFormula());
     }
    }
   }
  }

  //update the size of exceltable
  exceltable.setCellReferences(new AreaReference(
    new CellReference(exceltableStartRow, exceltableStartCol),
    new CellReference(exceltableEndRow, exceltableEndCol),
    SpreadsheetVersion.EXCEL2007));

 }


 public static void main(String[] args) throws Exception {

  Object rowData[][] = {
          {"Bob", 12.0, 3.0},
          {"Alice", 34.0, 2.5},
          {"Jack", 56.0, 2.0},
          {"John", 78.0, 1.5}
          };
  Object columnNames[] = {"Name", "Amount", "Factor"};
  DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
  JTable table = new JTable(model);
  table.setModel(model);

  File file = new File("IET.xlsx");
  FileInputStream inputStream = new FileInputStream(file);
  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(inputStream);

  XSSFTable exceltable = workbook.getTable("Table1");

  writeToExcel(exceltable, table);

  workbook.setForceFormulaRecalculation(true);

  FileOutputStream fileOut = new FileOutputStream(file);
  workbook.write(fileOut);
  fileOut.close();
  workbook.close();

 }
}