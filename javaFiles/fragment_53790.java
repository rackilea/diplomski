import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.Locale;

class GetDataFromExcelUsingDataFormatter {

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    String cellValue = dataFormatter.formatCellValue(cell, formulaEvaluator);
    System.out.println(cellValue);
   }
  }

  workbook.close();
 }
}