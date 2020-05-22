import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.SpreadsheetVersion;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

class ExcelPivotTableTest {

 public static void main(String[] args) throws Exception{

  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("PivotExample.xlsx"));
  XSSFSheet dataSheet = workbook.getSheet("Data");

  XSSFSheet pivotSheet = workbook.createSheet("Pivot");

  AreaReference a = new AreaReference("A1:G" + (dataSheet.getLastRowNum() + 1), SpreadsheetVersion.EXCEL2007);
  CellReference b = new CellReference("A1");

  XSSFPivotTable pivotTable = pivotSheet.createPivotTable(a, b, dataSheet);

  pivotTable.addRowLabel(6); //column G as first row label

  pivotTable.addRowLabel(0); //column A as second row label - shall be collapsed

  //we need unique contents in column A for creating the pivot cache
  Set<String> colAValues = new HashSet<String>();
  for (int r = 1; r < dataSheet.getLastRowNum() + 1; r++) {
   Row row = dataSheet.getRow(r);
   if (row != null) {
    Cell cell = row.getCell(0);
    if (cell != null) {
     colAValues.add(cell.toString());
    }
   }
  }

  //now go through all pivot items of first pivot field 
  List<org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem> itemList = 
   pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).getItems().getItemList();
  int i = 0; 
  org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem item = null;
  for (String value : colAValues) { //as long as there are different column A values
   item = itemList.get(i);
   item.unsetT(); //unset the type "default"
   item.setX(i++); //set x
   pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields()
    .getCacheFieldArray(0).getSharedItems().addNewS().setV(value); //create pivot cache entry
   item.setSd(false); //set sd false = indicates that the details are hidden for this item
  }
  while (i < itemList.size()) {
   item = itemList.get(i++);
   item.setSd(false);
  }


  pivotTable.addRowLabel(2); //column C as third row label

  pivotTable.addRowLabel(3); //column D as row label - shall be column label instead
  //do changing column D to a col label
  pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(3)
   .setAxis(org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.AXIS_COL); //AXIS_COL
  //remove column D from RowFields
  pivotTable.getCTPivotTableDefinition().getRowFields().removeField(3); 
  pivotTable.getCTPivotTableDefinition().getRowFields().setCount(3);
  //create ColFields for column D
  pivotTable.getCTPivotTableDefinition().addNewColFields().addNewField().setX(3); 
  pivotTable.getCTPivotTableDefinition().getColFields().setCount(1);

  pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 4, "Sum");

  workbook.write(new FileOutputStream("PivotExample_New.xlsx"));
  workbook.close();

 }
}