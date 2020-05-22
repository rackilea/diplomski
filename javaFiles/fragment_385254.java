import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

class DataFormatterAddFormat {

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

  dataFormatter.addFormat("0.0 p.p.;(0.0 p.p.)", 
   new java.text.DecimalFormat("0.0' p.p.';(0.0' p.p.')"));
  dataFormatter.addFormat("0.0\" p.p.\";\\(0.0\" p.p.\"\\)", 
   new java.text.DecimalFormat("0.0' p.p.';(0.0' p.p.')"));
  dataFormatter.addFormat("0.0\\ \\p.\\p.;\\(0.0\\ \\p.\\p.\\)", 
   new java.text.DecimalFormat("0.0' p.p.';(0.0' p.p.')"));

  Sheet sheet = workbook.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

     String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
     System.out.println(value);

   }
  }
  workbook.close();
 }
}