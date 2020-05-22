import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.*;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

class TestPivotTables {
 public static void main(String[] args) throws IOException{
  Workbook wb = new XSSFWorkbook();
  String[][] data = new String[][]{
   {"STATUS","PASSED","DATA","VALUE"}, 
   {"BLUE","Y","TTT","20"},
   {"RED","N","UUU","10"},
   {"BLUE","N","PPP","30"}
  };

  XSSFSheet sheet = (XSSFSheet) wb.createSheet("data");
  XSSFSheet pivot = (XSSFSheet) wb.createSheet("summary");
  for(String[] dataRow : data){
   XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
   for(String dataCell : dataRow){
    XSSFCell cell = row.createCell(row.getPhysicalNumberOfCells());
    cell.setCellValue(dataCell);
   }
  }

  AreaReference areaReference = new AreaReference("A1:D4", SpreadsheetVersion.EXCEL2007);
  XSSFPivotTable pivotTable = pivot.createPivotTable(areaReference, new CellReference("A4"), sheet);

  pivotTable.getCTPivotTableDefinition().setRowHeaderCaption("Colour");

  List<Integer> iterList = new ArrayList<Integer>();
  iterList.add(0);
  iterList.add(2);
  iterList.add(1);

  for (Integer j : iterList) {

   //create row label - apache poi creates as much fields for each as rows are in the pivot table data range
   pivotTable.addRowLabel(j);

   //determine unique labels in column j
   TreeSet<String> uniqueItems = new java.util.TreeSet<String>();
   for (int r = areaReference.getFirstCell().getRow()+1; r < areaReference.getLastCell().getRow()+1; r++) {
    uniqueItems.add(sheet.getRow(r).getCell(j).getStringCellValue());
   }
   System.out.println(uniqueItems);

   //build pivot table and cache
   CTPivotField ctPivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(j);
   int i = 0;
   for (String item : uniqueItems) {
    //take the items as numbered items: <item x="0"/><item x="1"/>
    ctPivotField.getItems().getItemArray(i).unsetT();
    ctPivotField.getItems().getItemArray(i).setX((long)i);
    //build a cache definition which has shared elements for those items 
    //<sharedItems><s v="BLUE"/><s v="RED"/></sharedItems>
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldArray(j)
     .getSharedItems().addNewS().setV(item);
    i++;
   }

   ctPivotField.setAutoShow(false);
   ctPivotField.setDefaultSubtotal(false);
   //ctPivotField.setSubtotalTop(false);
   //ctPivotField.setSubtotalCaption(null);
   ctPivotField.setCompact(false);

   //remove further items
   if (ctPivotField.getDefaultSubtotal()) i++; //let one default item be if there shall be subtotals
   for (int k = ctPivotField.getItems().getItemList().size()-1; k >= i; k--) {
    ctPivotField.getItems().removeItem(k);
   }
   ctPivotField.getItems().setCount(i);

  }

  System.out.println("----end---");

  pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 3, "test");

  FileOutputStream fileOut = new FileOutputStream("pivotsample1.xlsx");
  wb.write(fileOut);
  fileOut.close();
  wb.close();
 }
}