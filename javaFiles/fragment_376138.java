import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.*;

public class ExcelEvaluateSomeFunctions{

 public static void main(String[] args) throws Exception {
  Workbook workbook = WorkbookFactory.create(new FileInputStream("MSExcelWithVBA.xlsm"));
  Sheet this_sheet = workbook.getSheet("Sheet1");
  CreationHelper helper = workbook.getCreationHelper();

  XSSFFormulaEvaluator formulaevaluator = (XSSFFormulaEvaluator)helper.createFormulaEvaluator();
  WorkbookEvaluator workbookevaluator = formulaevaluator._getWorkbookEvaluator();
  ValueEval valueeval = null;

  //code_col = WorksheetFunction.Match("Code", this_sheet.Range("1:1"), 0)
  double code_col = Double.NaN;
  valueeval = workbookevaluator.evaluate("MATCH(\"Code\", " + this_sheet.getSheetName() + "!1:1, 0)", null);
  if (valueeval instanceof NumberEval) {
   code_col = ((NumberEval)valueeval).getNumberValue();
  }
  System.out.println("code_col: " + code_col);

  //payee_count = WorksheetFunction.CountIf(this_sheet.Range("A:A"), payee)
  String payee = "b";
  double payee_count = Double.NaN;
  valueeval = workbookevaluator.evaluate("COUNTIF(" + this_sheet.getSheetName() + "!A:A, \"" + payee + "\")", null);
  if (valueeval instanceof NumberEval) {
   payee_count = ((NumberEval)valueeval).getNumberValue();
  }
  System.out.println("payee_count: " + payee_count);

  //count_rows_in_region = this_sheet.Cells(1, 1).CurrentRegion.Rows.Count
  //this is not possible since apache poi does not know the concept of CurrentRegion
  //best you could do:
  int count_rows_in_sheet = this_sheet.getLastRowNum()+1;
  System.out.println("count_rows_in_sheet: " + count_rows_in_sheet);

  workbook.close();
 }  
}