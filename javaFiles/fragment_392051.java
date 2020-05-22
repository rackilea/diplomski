import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Name;

import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.WorkbookEvaluator;

import org.apache.poi.ss.formula.eval.*;

import org.apache.poi.ss.util.CellReference;

public class EvaluateExcelFunctions {

 static Object evaluateExcelFormula(String formula, Workbook workbookWithVariables) {
  if (workbookWithVariables.getNumberOfSheets() < 1) workbookWithVariables.createSheet();
  CellReference reference = new CellReference(workbookWithVariables.getSheetName(0), 0 , 0, false, false);
  CreationHelper helper = workbookWithVariables.getCreationHelper();
  FormulaEvaluator formulaevaluator = helper.createFormulaEvaluator();
  WorkbookEvaluator workbookevaluator = ((BaseFormulaEvaluator)formulaevaluator)._getWorkbookEvaluator();
  ValueEval valueeval = null;
  try {
   valueeval = workbookevaluator.evaluate(formula, reference);
  } catch (Exception ex) {
   return ex.toString();
  }
  if (valueeval instanceof StringValueEval) {
   String result = ((StringValueEval)valueeval).getStringValue();
   return result;
  } else if (valueeval instanceof NumericValueEval) {
   double result = ((NumericValueEval)valueeval).getNumberValue();
   return result;
  } else if (valueeval instanceof ErrorEval) {
   String result = ((ErrorEval)valueeval).getErrorString();
   return result;
  }
  return null;  
 }

 public static void main(String[] args) throws Exception {

  Workbook workbook = 
   //new XSSFWorkbook();
   new HSSFWorkbook();

  Name name;
  String formula;
  Object result;

  // example 1 concatenating strings - your example
  name = workbook.createName();
  name.setNameName("_a");
  name.setRefersToFormula("\"Text A \"");
  name = workbook.createName();
  name.setNameName("_b");
  name.setRefersToFormula("\"Text B \"");
  name = workbook.createName();
  name.setNameName("_c");
  name.setRefersToFormula("\"Text C \"");

  formula = "CONCATENATE(_a, _b, _c)";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  // example 2 Pythagorean theorem
  name = workbook.getName("_a"); 
  name.setRefersToFormula("12.34");
  name = workbook.getName("_b");
  name.setRefersToFormula("56.78");

  formula = "SQRT(_a^2 + _b^2)";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  // example 3 complex math formula
  name = workbook.getName("_a"); 
  name.setRefersToFormula("12.34");
  name = workbook.getName("_b");
  name.setRefersToFormula("56.78");
  name = workbook.getName("_c");
  name.setRefersToFormula("90.12");

  formula = "((_a+_b+_c)*_c/_b-_a)/2";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  // example 4 faulty formulas
  name = workbook.getName("_a"); 
  name.setRefersToFormula("56.78");
  name = workbook.getName("_b");
  name.setRefersToFormula("190.12");
  name = workbook.getName("_c");
  name.setRefersToFormula("\"text\"");

  formula = "_a + _c";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  formula = "((_a + _b";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  formula = "_a \\ 2";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  formula = "_a^_b";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  formula = "_a/(_b-_b)";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  formula = "CONCAT(_a, _b)";
  result = evaluateExcelFormula(formula, workbook);
  System.out.println(result);

  workbook.close();
 }  
}